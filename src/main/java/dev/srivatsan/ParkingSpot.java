package dev.srivatsan;

import lombok.Getter;
import lombok.ToString;

@ToString
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
            return true;
        } else {
            return vehicle instanceof Motorcycle;
        }
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void leave() {
        this.vehicle = null;
    }
}
