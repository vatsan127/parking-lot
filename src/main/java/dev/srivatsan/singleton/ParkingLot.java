package dev.srivatsan.singleton;

import dev.srivatsan.factory.Vehicle;
import dev.srivatsan.observer.ParkingObserver;
import dev.srivatsan.strategy.PaymentStrategy;
import dev.srivatsan.template.*;
import dev.srivatsan.template.ParkingSpot;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final List<ParkingSpot> spots;
    private final List<ParkingObserver> observers;
    private final Map<String, Vehicle> parkedVehicles;

    @Setter
    private PaymentStrategy paymentStrategy;

    public ParkingLot(int numCarSpots, int numBikeSpots) {
        spots = new ArrayList<>();
        observers = new ArrayList<>();
        parkedVehicles = new HashMap<>();

        int spotId = 1;
        for (int i = 0; i < numCarSpots; i++) {
            spots.add(new CarSpot(spotId++));
        }

        for (int i = 0; i < numBikeSpots; i++) {
            spots.add(new BikeSpot(spotId++));
        }
    }

    public void registerObserver(ParkingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ParkingObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ParkingObserver observer : observers) {
            observer.update(this);
        }
    }

    public int getAvailableSpots(String vehicleType) {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() ||
                    (vehicleType.equals("Bike") && spot instanceof CarSpot &&
                            spot.isOccupied() && spot.parkedVehicle.getType().equals("Bike"))) {
                count++;
            }
        }
        return count;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        // Check if vehicle is already parked
        if (parkedVehicles.containsKey(vehicle.getLicensePlate())) {
            System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " is already parked");
            return false;
        }

        // Find suitable spot for the vehicle
        for (ParkingSpot spot : spots) {
            if (spot.canPark(vehicle)) {
                boolean parked = spot.parkVehicle(vehicle);
                if (parked) {
                    parkedVehicles.put(vehicle.getLicensePlate(), vehicle);
                    System.out.println(vehicle.getType() + " with license plate " +
                            vehicle.getLicensePlate() + " parked in spot " + spot.getId());
                    notifyObservers();
                    return true;
                }
            }
        }

        System.out.println("No available spots for " + vehicle.getType() +
                " with license plate " + vehicle.getLicensePlate());
        return false;
    }

    public boolean removeVehicle(String licensePlate) {
        if (!parkedVehicles.containsKey(licensePlate)) {
            System.out.println("Vehicle with license plate " + licensePlate + " is not in the parking lot");
            return false;
        }

        Vehicle vehicle = parkedVehicles.get(licensePlate);

        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.parkedVehicle != null &&
                    spot.parkedVehicle.getLicensePlate().equals(licensePlate)) {

                Vehicle removedVehicle = spot.removeVehicle();
                if (removedVehicle != null) {
                    parkedVehicles.remove(licensePlate);
                    System.out.println(vehicle.getType() + " with license plate " +
                            licensePlate + " removed from spot " + spot.getId());
                    notifyObservers();
                    return true;
                }
            }
        }

        return false;
    }

    public boolean processPayment(String licensePlate) {
        if (paymentStrategy == null) {
            System.out.println("Payment strategy not set");
            return false;
        }

        if (parkedVehicles.containsKey(licensePlate)) {
            Vehicle vehicle = parkedVehicles.get(licensePlate);
            double amount = vehicle.getPaymentAmount();
            boolean paymentSuccess = paymentStrategy.pay(amount);

            if (paymentSuccess) {
                return removeVehicle(licensePlate);
            }
        } else {
            System.out.println("Vehicle with license plate " + licensePlate + " is not in the parking lot");
        }

        return false;
    }
}