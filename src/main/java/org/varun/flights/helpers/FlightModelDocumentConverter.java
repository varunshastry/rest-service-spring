package org.varun.flights.helpers;

import org.varun.flights.models.Flight;

public class FlightModelDocumentConverter {
    private static FlightModelDocumentConverter instance;
    private FlightModelDocumentConverter() {
    }

    public static FlightModelDocumentConverter getInstance() {
        if(instance == null) {
            instance = new FlightModelDocumentConverter();
        }
        return instance;
    }

    public org.varun.flights.elasticsearch.documents.Flight convertModelToDocument(Flight flightModel) {
        return new org.varun.flights.elasticsearch.documents.Flight(flightModel.getFlightName(), flightModel.getFlightId());
    }

    public Flight convertDocumentToModel(org.varun.flights.elasticsearch.documents.Flight flightDocument) {
        return new Flight(flightDocument.getFlightName(), flightDocument.getFlightId());
    }
}
