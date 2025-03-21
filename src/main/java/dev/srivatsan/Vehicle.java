package dev.srivatsan;

import lombok.Getter;

public abstract class Vehicle {
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

    @Override
    public String toString() {
        return "Car (" + licensePlate + ")";
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

    @Override
    public String toString() {
        return "Motorcycle (" + licensePlate + ")";
    }
}
