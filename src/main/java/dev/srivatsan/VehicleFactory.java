package dev.srivatsan;

/**
 * Factory Pattern
 */

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
