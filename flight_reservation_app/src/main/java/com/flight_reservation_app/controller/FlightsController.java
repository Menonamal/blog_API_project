package com.flight_reservation_app.controller;


import java.util.Date; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entity.Flights;
import com.flight_reservation_app.repository.FlightRepository;

@Controller
public class FlightsController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	
	@RequestMapping ("/findFlights")
	public String findFlights(@RequestParam("from")String from, @RequestParam("to")String to, @RequestParam("departureDate")@DateTimeFormat(pattern = "MM-dd-yyy")Date departureDate, ModelMap modelMap) {
		
		List<Flights> findFlights = flightRepository.findFlights(from, to,  departureDate);
		modelMap.addAttribute("findFlights",findFlights);
		System.out.println(findFlights);
		return "login/displayFlights";
	}
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId, ModelMap modelMap) {
		System.out.println(flightId);
		Optional<Flights> foundById = flightRepository.findById(flightId);
		Flights flight = foundById.get();
		modelMap.addAttribute("flight",flight);
//		System.out.println(flight.getId());
//		System.out.println(flight.getDepartureCity());
//		System.out.println(flight.getArrivalCity());
//		System.out.println(flight.getOperatingAirlines());
//		System.out.println(flight.getFlightNumber());
//		System.out.println(flight.getDateOfDeparture());
//		System.out.println(flight.getEstimatedDepartureTime());
		return "login/showReservation";
		
	}

}
