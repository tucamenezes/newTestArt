package com.flightsearch.controller;

import com.flightsearch.model.ListFlights;
import com.flightsearch.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class FlightSearchController {

    @Autowired
    private FlightSearchService service;

    @RequestMapping(value="listflights/{time}", method=RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public ResponseEntity<ListFlights> getFlights(@PathVariable("time") String timeFlight) throws Exception {


        return new ResponseEntity<>(service.getFlights(timeFlight), HttpStatus.OK);

    }

    @RequestMapping(value="listflights", method=RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public ResponseEntity<ListFlights> getAllFlights() throws Exception {

        return new ResponseEntity<>(service.getAllFlights(), HttpStatus.OK);

    }
}
