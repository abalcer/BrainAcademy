package com.brainacademy.vehicle;

public class MotorVehicle
        extends Vehicle
        implements Refuellable {

    public MotorVehicle() {
        System.out.println("MotorVehicle");
    }

    @Override
    public void refuel() {
    }
}
