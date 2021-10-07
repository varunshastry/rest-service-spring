package org.varun.flights.helpers;

import org.junit.jupiter.api.Test;
import org.varun.flights.models.Flight;

class FlightModelDocumentConverterTest {

    @Test
    void getInstance() {
        FlightModelDocumentConverter converter = FlightModelDocumentConverter.getInstance();
        assert converter instanceof FlightModelDocumentConverter;
        FlightModelDocumentConverter anotherConverter = FlightModelDocumentConverter.getInstance();
        assert converter == anotherConverter;
    }

    @Test
    void convertModelToDocument() {
        FlightModelDocumentConverter converter = FlightModelDocumentConverter.getInstance();
        Flight flightModel = new Flight("AirBus", "123");
        org.varun.flights.elasticsearch.documents.Flight flightDocument = converter.convertModelToDocument(flightModel);
        assert flightDocument.getFlightName().equals(flightModel.getFlightName());
        assert flightDocument.getFlightId().equals(flightModel.getFlightId());
    }

    @Test
    void convertDocumentToModel() {
        FlightModelDocumentConverter converter = FlightModelDocumentConverter.getInstance();
        org.varun.flights.elasticsearch.documents.Flight flightDocument = new org.varun.flights.elasticsearch.documents.Flight("AirBus", "123");
        Flight flightModel = converter.convertDocumentToModel(flightDocument);
        assert flightModel.getFlightName().equals(flightDocument.getFlightName());
        assert flightModel.getFlightId().equals(flightDocument.getFlightId());
    }
}