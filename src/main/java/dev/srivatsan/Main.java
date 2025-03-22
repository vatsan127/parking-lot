package dev.srivatsan;

import dev.srivatsan.factory.Vehicle;
import dev.srivatsan.factory.VehicleFactory;
import dev.srivatsan.observer.ParkingObserver;
import dev.srivatsan.observer.ParkingUser;
import dev.srivatsan.singleton.ParkingLot;
import dev.srivatsan.strategy.CashPayment;
import dev.srivatsan.strategy.GPayPayment;

public class Main {
    public static void main(String[] args) {
        // Create a parking lot with 2 car spots and 4 bike spots
        ParkingLot parkingLot = new ParkingLot(2, 4);

        // Register observers
        ParkingObserver carUser = new ParkingUser("John", "Car");
        ParkingObserver bikeUser = new ParkingUser("Alice", "Bike");
        parkingLot.registerObserver(carUser);
        parkingLot.registerObserver(bikeUser);

        // Create vehicles using factory
        Vehicle car1 = VehicleFactory.createVehicle("Car", "CAR001");
        Vehicle car2 = VehicleFactory.createVehicle("Car", "CAR002");
        Vehicle bike1 = VehicleFactory.createVehicle("Bike", "BIKE001");
        Vehicle bike2 = VehicleFactory.createVehicle("Bike", "BIKE002");

        // Park vehicles
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(bike2);

        // Set payment strategy and process payment
        parkingLot.setPaymentStrategy(new GPayPayment("john@example.com"));
        parkingLot.processPayment("CAR001");

        // Switch payment strategy
        parkingLot.setPaymentStrategy(new CashPayment());
        parkingLot.parkVehicle(car2);
        parkingLot.processPayment("CAR002");
    }
}
