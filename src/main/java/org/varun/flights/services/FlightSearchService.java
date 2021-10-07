package org.varun.flights.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.varun.flights.elasticsearch.documents.Flight;
import org.varun.flights.elasticsearch.repositories.FlightRepository;

import java.util.List;

@Service
public class FlightSearchService {
    @Autowired
    private FlightRepository flightRepository;

    public void createFlightIndex(Flight flight) {
        this.flightRepository.save(flight);
    }

    public void createFlightIndexBulk(List<Flight> flights) {
        this.flightRepository.saveAll(flights);
    }

    public List<Flight> getFlightsByFlightName(String flightName) {
        return this.flightRepository.findByFlightNameContaining(flightName);
    }

    public List<Flight> getFlightsByFlightId(String flightId) {
        return this.flightRepository.findByFlightIdContaining(flightId);
    }
}
