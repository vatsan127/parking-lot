package dev.srivatsan;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();

        Vehicle car = VehicleFactory.createVehicle("Car", "ABC123");
        Vehicle motorcycle = VehicleFactory.createVehicle("Motorcycle", "XYZ987");

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

        parkingLot.displayLotStatus();

        parkingLot.removeVehicle(car);
        System.out.println(car.getLicensePlate() + " has left the parking lot.");

        parkingLot.displayLotStatus();
    }
}
