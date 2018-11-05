package com.flightsearch.application;

import com.flightsearch.controller.FlightSearchController;
import com.flightsearch.helper.HelperFile;
import com.flightsearch.model.ListFlights;
import com.flightsearch.service.FlightSearchService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
public class FlightSearchControllerTest {

    private String PATH_APP = "/v1/listflights";

    private MockMvc mvc;

    @Mock
    private FlightSearchService service;

    @InjectMocks
    private FlightSearchController flightSearchController;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(flightSearchController)
                .setControllerAdvice(new ExceptionHandlerControllerTest()).build();


    }

    @Test
    public void getAllFlightsTest() throws Exception {
        ListFlights flights = new Gson().fromJson(HelperFile.loadFileJson("flights.json"), ListFlights.class);

        MockHttpServletRequestBuilder requestBuilder = get(PATH_APP);

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk());

    }


    @Test
    public void getFlightsTest() throws Exception {
        String jsonFlights = HelperFile.loadFileJson("flightsQuery.json");

        ListFlights flights = new Gson().fromJson(jsonFlights, ListFlights.class);

        Mockito.when(service.getFlights(Mockito.anyString())).thenReturn(flights);

        MockHttpServletRequestBuilder requestBuilder = get(PATH_APP + "/1:00 PM");

        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(jsonFlights));
    }

}
