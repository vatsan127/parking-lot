package dev.srivatsan;

public class Main {
    public static void main(String[] args) {
        // Get the singleton parking lot instance
        ParkingLot parkingLot = ParkingLot.getInstance();

        // Create vehicles using the factory
        Vehicle car = VehicleFactory.createVehicle("Car", "ABC123");
        Vehicle motorcycle = VehicleFactory.createVehicle("Motorcycle", "XYZ987");

        // Park vehicles
        boolean parkedCar = parkingLot.parkVehicle(car);
        boolean parkedMotorcycle = parkingLot.parkVehicle(motorcycle);

        if (parkedCar) {
            System.out.println(car.getLicensePlate() + " parked.");
        } else {
            System.out.println("No available spot for " + car.getLicensePlate());
        }

        if (parkedMotorcycle) {
            System.out.println(motorcycle.getLicensePlate() + " parked.");
        } else {
            System.out.println("No available spot for " + motorcycle.getLicensePlate());
        }

        // Display the current parking lot status
        parkingLot.displayLotStatus();

        // Remove a vehicle (Car in this case)
        parkingLot.removeVehicle(car);
        System.out.println(car.getLicensePlate() + " has left the parking lot.");

        // Display lot status after removal
        parkingLot.displayLotStatus();
    }
}
