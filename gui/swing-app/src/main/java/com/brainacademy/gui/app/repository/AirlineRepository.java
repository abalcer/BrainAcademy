package com.brainacademy.gui.app.repository;

import com.brainacademy.gui.app.model.Airline;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirlineRepository
        extends CrudRepository<Airline, Integer> {

    @Query("select a from Airline a where a.name like :name")
    List<Airline> findByName(@Param("name") String name);
}
