package dev.srivatsan.factory;

import static dev.srivatsan.constants.ParkingLotConstants.BIKE;
import static dev.srivatsan.constants.ParkingLotConstants.BIKE_PARKING_RATE;

public class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(BIKE, licensePlate, BIKE_PARKING_RATE);
    }
}