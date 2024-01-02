package com.airline.service;

import com.airline.model.Flight;

import java.util.List;

public interface FlightService {

    Flight addFlight(Flight flight);

    List<Flight> getAllFlight();

    Flight getFlight(int flightId) throws Exception;

    void deleteFlight(int flightId);

    Flight updateFlight(int flightId, Flight flight);
}
