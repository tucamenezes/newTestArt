package com.flightsearch.helper;

import com.flightsearch.model.Flight;
import com.flightsearch.model.ListFlights;
import com.google.gson.Gson;

import java.util.List;


/**
 * Cette Classe est utilisée pour recuperer les vols.
 */
public class HelperApp {

    public static List<Flight> getFlights () {

        String fileJson = HelperFile.loadFileJson("flights.json");
        ListFlights flights = new Gson().fromJson(fileJson, ListFlights.class);

        return flights.getFlights();

    }


}
