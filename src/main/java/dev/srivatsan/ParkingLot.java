package dev.srivatsan;

public class ParkingLot { // Singleton

    private static ParkingLot instance;
    private ParkingSpot[] parkingSpots;

    private ParkingLot() {
        parkingSpots = new ParkingSpot[6]; // 6 spots in total
        for (int i = 0; i < 6; i++) {
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
