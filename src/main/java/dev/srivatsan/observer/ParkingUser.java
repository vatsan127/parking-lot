package dev.srivatsan.observer;

import dev.srivatsan.singleton.ParkingLot;

public class ParkingUser implements ParkingObserver {
    private String name;
    private String vehicleType;

    public ParkingUser(String name, String vehicleType) {
        this.name = name;
        this.vehicleType = vehicleType;
    }

    @Override
    public void update(ParkingLot parkingLot) {
        int availableSpots = parkingLot.getAvailableSpots(vehicleType);
        System.out.println("Hi " + name + ", there are now " + availableSpots +
                " spots available for your " + vehicleType);
    }
}