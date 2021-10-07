package org.varun.flights.models;

public class Flight {
    private String flightId;
    private String flightName;

    public Flight(String flightName, String flightId) {
        this.flightName = flightName;
        this.flightId = flightId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    @Override
    public String toString() {
        return "Flight [Name=" + flightName + ", Id=" + flightId + "]";
    }
}
