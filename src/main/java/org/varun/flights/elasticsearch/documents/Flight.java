package org.varun.flights.elasticsearch.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "flightindex")
public class Flight {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String flightName;

    @Field(type = FieldType.Text, name = "flightId")
    private String flightId;

    public Flight(String flightName, String flightId) {
        this.flightName = flightName;
        this.flightId = flightId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
