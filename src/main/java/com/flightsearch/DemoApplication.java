package com.flightsearch;

import com.flightsearch.helper.HelperTime;
import com.flightsearch.model.Flight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



		Flight flight = new Flight("Delta 3833","3:00 PM");

		System.out.println(flight.getFlight());

		try {
			System.out.println(HelperTime.addHoursTime(flight.transformDepartureAsTime(), 5));
		} catch (ParseException e) {
			e.printStackTrace();
		}



	}
}
