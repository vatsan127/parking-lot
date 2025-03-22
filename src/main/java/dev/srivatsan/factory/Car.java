package dev.srivatsan.factory;

import static dev.srivatsan.constants.ParkingLotConstants.CAR;
import static dev.srivatsan.constants.ParkingLotConstants.CAR_PARKING_RATE;

public class Car extends Vehicle {

    public Car(String licensePlate) {
        super(CAR, licensePlate, CAR_PARKING_RATE);
    }

}
