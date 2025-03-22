package dev.srivatsan.observer;

import dev.srivatsan.singleton.ParkingLot;

public interface ParkingObserver {
    void update(ParkingLot parkingLot);
}