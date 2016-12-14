package com.barainacademy.elevator.service;

import com.barainacademy.elevator.model.Elevator;
import com.barainacademy.elevator.model.House;

public class ElevatorService {
    private House house;

    public Elevator callElevator(int floor) {
        return null;

    }

    public int moveTo(Elevator elevator, int floor) {
        if(floor > house.getTotalFloors()) {
            return - 1;
        }
        elevator.setFloor(floor);
        return floor;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public House getHouse() {
        return house;
    }
}
