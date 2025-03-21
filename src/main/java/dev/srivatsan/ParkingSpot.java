package dev.srivatsan;

import lombok.Getter;

public class ParkingSpot {
    private final int spotNumber;

    @Getter
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    // Check if the vehicle can fit in the spot
    public boolean canFit(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return true; // All spots can fit a car
        } else {
            return vehicle instanceof Motorcycle; // All spots can fit a motorcycle
        }
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void leave() {
        this.vehicle = null;
    }

    @Override
    public String toString() {
        return "Spot #" + spotNumber + (vehicle == null ? " is available" : " is occupied by " + vehicle);
    }
}
