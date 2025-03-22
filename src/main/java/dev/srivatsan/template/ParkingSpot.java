package dev.srivatsan.template;

import dev.srivatsan.factory.Vehicle;

public abstract class ParkingSpot {
    public int id;
    public boolean isOccupied;
    public Vehicle parkedVehicle;

    public ParkingSpot(int id) {
        this.id = id;
        this.isOccupied = false;
    }

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public abstract boolean canPark(Vehicle vehicle);

    public boolean parkVehicle(Vehicle vehicle) {
        if (!isOccupied && canPark(vehicle)) {
            this.parkedVehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public Vehicle removeVehicle() {
        if (isOccupied) {
            Vehicle vehicle = this.parkedVehicle;
            this.parkedVehicle = null;
            this.isOccupied = false;
            return vehicle;
        }
        return null;
    }
}