package dev.srivatsan;

/**
 * Strategy Pattern
 */

public interface ParkingStrategy {
    boolean canPark(ParkingSpot spot, Vehicle vehicle);
}

class SimpleParkingStrategy implements ParkingStrategy {
    @Override
    public boolean canPark(ParkingSpot spot, Vehicle vehicle) {
        return spot.isAvailable() && spot.canFit(vehicle);
    }
}
