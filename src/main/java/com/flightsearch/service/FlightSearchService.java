package com.flightsearch.service;

import com.flightsearch.model.ListFlights;
import java.text.ParseException;


public interface FlightSearchService {

    ListFlights getAllFlights();

    ListFlights getFlights(String timeFlight) throws ParseException;
}
