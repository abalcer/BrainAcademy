package com.brainacademy.gui.app.repository;

import com.brainacademy.gui.app.model.Airport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository
        extends CrudRepository<Airport, Integer> {

    Airport findByName(String name);
}
