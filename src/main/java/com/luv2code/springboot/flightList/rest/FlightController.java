package com.luv2code.springboot.flightList.rest;

import com.luv2code.springboot.flightList.entity.Flight;
import com.luv2code.springboot.flightList.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	@GetMapping
	public @ResponseBody
    List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}


	@PostMapping
	public Flight addEmployee(@RequestBody Flight flight) {
		flightService.save(flight);
		return flight;
	}

	@GetMapping("/{flight-id}")
	public @ResponseBody
    Flight getFlightById(@PathVariable("flight-id") int flightId) {
		return flightService.getFlightById(flightId);
	}
}
