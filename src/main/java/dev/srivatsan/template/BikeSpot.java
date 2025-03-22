package dev.srivatsan.template;

import dev.srivatsan.factory.Vehicle;

public class BikeSpot extends ParkingSpot {
    public BikeSpot(int id) {
        super(id);
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        if (vehicle.getType().equals("Bike")) {
            return !isOccupied;
        }
        return false;
    }
}