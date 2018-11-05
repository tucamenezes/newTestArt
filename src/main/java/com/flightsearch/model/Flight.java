package com.flightsearch.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {

    private String flight;

    private String departure;

    public Flight() {
    }

    public Flight(String flight, String departure) {
        this.flight = flight;
        this.departure = departure;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }


    /**
     * Cette méthode est utilisée pour transformer la date String en un Objet Date.
     */
    public Date transformDepartureAsTime() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");

        return dateFormat.parse(this.departure);
    }

}
