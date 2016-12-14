package com.barainacademy.elevator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.barainacademy.elevator.model.Elevator;
import com.barainacademy.elevator.model.House;

public class ElevatorServiceTest {

    private ElevatorService elevatorService;
    private House house;

    @BeforeEach
    public void setUp() {
        house = new House();
        house.setTotalFloors(10);

        elevatorService = new ElevatorService();
        elevatorService.setHouse(house);
    }

    @Test
    public void callElevator_SuccessTest() {
        Elevator elevator1 = new Elevator();
        elevator1.setId(1);
        elevator1.setFloor(1);

        Elevator elevator2 = new Elevator();
        elevator2.setId(2);
        elevator2.setFloor(2);

        Elevator elevator3 = new Elevator();
        elevator3.setId(3);
        elevator3.setFloor(3);

        house.addElevator(elevator1);
        house.addElevator(elevator2);
        house.addElevator(elevator3);

        int floor = 5;
        Elevator elevator = elevatorService.callElevator(floor);
        assertNotNull(elevator);

        assertEquals(3, elevator.getId());
        assertEquals(floor, elevator.getFloor());
    }

    @Test
    public void moveTo_SuccessTest() {
        Elevator elevator = new Elevator();
        elevator.setId(1);
        elevator.setFloor(4);

        house.addElevator(elevator);

        int floor = elevatorService.moveTo(elevator, 1);
        assertEquals(1, floor);
        assertEquals(1, elevator.getFloor());
    }

    @Test
    public void moveTo_FailedTest() {
        int oldFloor = 4;

        Elevator elevator = new Elevator();
        elevator.setId(1);
        elevator.setFloor(oldFloor);

        house.addElevator(elevator);

        int floor = elevatorService.moveTo(elevator, house.getTotalFloors() + 1);
        assertEquals(- 1, floor);
        assertEquals(oldFloor, elevator.getFloor());
    }
}