package dev.srivatsan.template;

import dev.srivatsan.factory.Vehicle;

public class CarSpot extends ParkingSpot {
    private boolean hasBike;

    public CarSpot(int id) {
        super(id);
        this.hasBike = false;
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        if (vehicle.getType().equals("Car")) {
            return !isOccupied && !hasBike;
        } else if (vehicle.getType().equals("Bike")) {
            return !isOccupied || (!hasBike && isOccupied && parkedVehicle.getType().equals("Bike"));
        }
        return false;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        if (vehicle.getType().equals("Car") && !isOccupied && !hasBike) {
            this.parkedVehicle = vehicle;
            this.isOccupied = true;
            return true;
        } else if (vehicle.getType().equals("Bike")) {
            if (!isOccupied) {
                this.parkedVehicle = vehicle;
                this.isOccupied = true;
                this.hasBike = true;
                return true;
            } else if (isOccupied && parkedVehicle.getType().equals("Bike") && !hasBike) {
                // We have one bike already, adding a second one
                this.hasBike = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle removeVehicle() {
        if (isOccupied) {
            if (hasBike) {
                hasBike = false;
                return null; // We still have one bike left
            } else {
                Vehicle vehicle = this.parkedVehicle;
                this.parkedVehicle = null;
                this.isOccupied = false;
                return vehicle;
            }
        }
        return null;
    }
}
