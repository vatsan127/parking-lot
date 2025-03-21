package dev.srivatsan;

/**
 * Singleton Pattern
 */

public class ParkingLot {

    private final int totalSpots = 6;
    private static ParkingLot instance;
    private ParkingSpot[] parkingSpots;

    private ParkingLot() {
        parkingSpots = new ParkingSpot[totalSpots];
        for (int i = 0; i < totalSpots; i++) {
            parkingSpots[i] = new ParkingSpot(i + 1);
        }
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    // Park a vehicle in the parking lot
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.canFit(vehicle)) {
                spot.park(vehicle);
                return true;
            }
        }
        return false;
    }

    // Remove a vehicle from the parking lot
    public void removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getVehicle() == vehicle) {
                spot.leave();
                break;
            }
        }
    }

    // Display current parking lot status
    public void displayLotStatus() {
        for (ParkingSpot spot : parkingSpots) {
            System.out.println(spot);
        }
    }

}
