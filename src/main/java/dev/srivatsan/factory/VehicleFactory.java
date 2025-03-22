package dev.srivatsan.factory;

import static dev.srivatsan.constants.ParkingLotConstants.BIKE;
import static dev.srivatsan.constants.ParkingLotConstants.CAR;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String licensePlate) {
        if (CAR.equalsIgnoreCase(type)) {
            return new Car(licensePlate);
        } else if (BIKE.equalsIgnoreCase(type)) {
            return new Bike(licensePlate);
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}
