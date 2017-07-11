package com.barainacademy.elevator.model;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int totalFloors;
    private List<Elevator> elevators = new ArrayList<>();

    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }
}
