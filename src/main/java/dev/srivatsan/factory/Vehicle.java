package dev.srivatsan.factory;

import lombok.Data;

@Data
public class Vehicle {

    private final String licensePlate;
    private final String type;
    private final double paymentAmount;

}