package com.flightsearch.model;


import java.util.ArrayList;
import java.util.List;


/**
 * Cette Classe auxiliaire est utilisée pour aider à récupérer la liste des vols
 */
public class ListFlights {

    private List<Flight> flights;

    public ListFlights() {
        this.flights = new ArrayList<>();
    }



    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
