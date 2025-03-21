package dev.srivatsan;

import lombok.Getter;

public class ParkingSpot {
    private int spotNumber;
    // Get the vehicle in the spot
    @Getter
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    // Check if the spot is available
    public boolean isAvailable() {
        return vehicle == null;
    }

    // Check if the vehicle can fit in the spot
    public boolean canFit(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return true; // All spots can fit a car
        } else if (vehicle instanceof Motorcycle) {
            return true; // All spots can fit a motorcycle
        }
        return false;
    }

    // Park the vehicle in this spot
    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Remove the vehicle from the spot
    public void leave() {
        this.vehicle = null;
    }

    @Override
    public String toString() {
        return "Spot #" + spotNumber + (vehicle == null ? " is available" : " is occupied by " + vehicle);
    }
}
