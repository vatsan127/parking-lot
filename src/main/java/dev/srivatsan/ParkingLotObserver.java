package dev.srivatsan;

public interface ParkingLotObserver {
    void update(String status);
}

class ParkingLotObserverImpl implements ParkingLotObserver {
    @Override
    public void update(String status) {
        System.out.println("Parking Lot Status: " + status);
    }
}
