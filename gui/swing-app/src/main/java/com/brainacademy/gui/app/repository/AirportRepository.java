package com.brainacademy.gui.app.repository;

import com.brainacademy.gui.app.model.Airport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository
        extends CrudRepository<Airport, Integer> {

    @Query("select a from Airport a where a.name like :name")
    List<Airport> findByName(@Param("name") String name);
}
