package com.airline.service.impl;

import com.airline.model.Flight;
import com.airline.repository.FlightRepository;
import com.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlight(int flightId) throws Exception {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);

        if (optionalFlight.isPresent()) {
            return optionalFlight.get();
        } else {
            throw new Exception("Flight not found with ID: " + flightId);
        }
    }

    @Override
    public void deleteFlight(int flightId) {
        flightRepository.deleteById(flightId);
    }

    @Override
    public Flight updateFlight(int flightId, Flight flight) {
        flight.setFlightId(flightId);
        return flightRepository.save(flight);
    }
}
