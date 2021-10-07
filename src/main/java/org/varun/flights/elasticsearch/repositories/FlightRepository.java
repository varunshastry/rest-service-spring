package org.varun.flights.elasticsearch.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.varun.flights.elasticsearch.documents.Flight;

import java.util.List;

public interface FlightRepository extends ElasticsearchRepository<Flight, String> {
    List<Flight> findByFlightNameContaining(String flightName);

    List<Flight> findByFlightIdContaining(String flightId);
}
