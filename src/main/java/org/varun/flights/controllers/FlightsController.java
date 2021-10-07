package org.varun.flights.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.varun.flights.helpers.FlightModelDocumentConverter;
import org.varun.flights.models.Flight;
import org.varun.flights.services.FlightSearchService;

import java.util.LinkedList;
import java.util.List;

@RestController
public class FlightsController {
    @Autowired
    private FlightSearchService flightSearchService;

    @RequestMapping(value = "/flights")
    public ResponseEntity<Object> getFlightsByFlightName(@RequestParam(value = "flightName", required = false, defaultValue = "") String flightName) {
        List<Flight> flightModels = new LinkedList<>();
        FlightModelDocumentConverter converter = FlightModelDocumentConverter.getInstance();
        for (org.varun.flights.elasticsearch.documents.Flight flightDocument : flightSearchService.getFlightsByFlightName(flightName)) {
            flightModels.add(converter.convertDocumentToModel(flightDocument));
        }
        return new ResponseEntity<>(flightModels, HttpStatus.OK);
    }

    @RequestMapping(value = "/flights", method = RequestMethod.POST)
    public ResponseEntity<Object> createFlight(@RequestBody Flight flightModel) {
        FlightModelDocumentConverter converter = FlightModelDocumentConverter.getInstance();
        org.varun.flights.elasticsearch.documents.Flight flightDocument = converter.convertModelToDocument(flightModel);
        flightSearchService.createFlightIndex(flightDocument);
        return new ResponseEntity<>("Flight added successfully", HttpStatus.CREATED);
    }
}
