package com.brainacademy.gui.app.repository;

import com.brainacademy.gui.app.model.Airport;
import com.brainacademy.gui.app.model.Route;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, Integer> {

    List<Route> findBySrcAirport(Airport airport);
}
