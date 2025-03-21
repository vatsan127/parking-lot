package dev.srivatsan;

import lombok.Getter;
import lombok.ToString;

/**
 * Factory Pattern
 */

@ToString
abstract class Vehicle {
    @Getter
    protected String licensePlate;
    protected String vehicleType;

    public Vehicle(String licensePlate, String vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public abstract int getSize();
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, "Car");
    }

    @Override
    public int getSize() {
        return 2;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, "Motorcycle");
    }

    @Override
    public int getSize() {
        return 1;
    }
}

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String licensePlate) {
        if ("Car".equalsIgnoreCase(vehicleType)) {
            return new Car(licensePlate);
        } else if ("Motorcycle".equalsIgnoreCase(vehicleType)) {
            return new Motorcycle(licensePlate);
        }
        throw new IllegalArgumentException("Unknown vehicle type");
    }
}
