package com.flightsearch.service;


import com.flightsearch.helper.HelperApp;
import com.flightsearch.helper.HelperTime;
import com.flightsearch.model.Flight;
import com.flightsearch.model.ListFlights;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

    private final int TIME_FLIGHTS = 5;

    @Override
    public  ListFlights getAllFlights() {
        ListFlights flights =  new ListFlights();
        flights.getFlights().addAll(HelperApp.getFlights());

        return flights;
    }

    @Override
    public ListFlights getFlights(String timeFlight) throws ParseException {
        ListFlights flights =  new ListFlights();

        List<Flight> allFlights =  HelperApp.getFlights();
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");
        Date dateFligth = dateFormat.parse(timeFlight);


        if (!CollectionUtils.isEmpty(allFlights)) {

            for (Flight flight : allFlights) {

                if ((flight.transformDepartureAsTime().getTime() >= HelperTime.addHoursTime(dateFligth, -TIME_FLIGHTS).getTime())
                    && (flight.transformDepartureAsTime().getTime() <= HelperTime.addHoursTime(dateFligth, TIME_FLIGHTS).getTime())){
                    flights.getFlights().add(flight);
                }

            }
        }

        return flights;
    }

}
