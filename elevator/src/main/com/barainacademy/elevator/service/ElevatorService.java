package com.barainacademy.elevator.service;

import java.util.Collections;
import java.util.Comparator;

import com.barainacademy.elevator.model.Elevator;
import com.barainacademy.elevator.model.House;

public class ElevatorService {
    private House house;

    public Elevator callElevator(int floor) {
        if (floor > house.getTotalFloors()) {
            return null;
        }

        Elevator elevator = Collections.min(house.getElevators(), new Comparator<Elevator>() {
            @Override
            public int compare(Elevator o1, Elevator o2) {
                int dst1 = Math.abs(o1.getFloor() - floor);
                int dst2 = Math.abs(o2.getFloor() - floor);
                return Integer.compare(dst1, dst2);
            }
        });

        elevator.setFloor(floor);
        return elevator;

    }

    public int moveTo(Elevator elevator, int floor) {
        if (floor > house.getTotalFloors()) {
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
