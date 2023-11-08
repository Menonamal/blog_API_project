package com.flight_reservation_app.service;

import java.util.Optional;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entity.Flights;
import com.flight_reservation_app.entity.Passenger;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.FlightRepository;
import com.flight_reservation_app.repository.PassengerRepository;
import com.flight_reservation_app.repository.ReservationRepository;
import com.flight_reservation_app.utilities.EmailUtil;
import com.flight_reservation_app.utilities.PDFgenerator;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private ReservationRepository reservationRepo; 
	@Autowired
	private PDFgenerator pdfGenerator;
	@Autowired 
	private EmailUtil emailUtil;
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		System.out.println(request.getFirstName());
			passengerRepo.save(passenger);
		long flightId = request.getFlightId();
		Optional<Flights> findById = flightRepo.findById(flightId);
		System.out.println(flightId);
		Flights flights = findById.get();
			Reservation reservation = new Reservation();
		reservation.setFlight(flights);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\flight_reservation_app\\tickets\\reservation"+reservation.getId()+".pdf";
		reservationRepo.save(reservation);
		
		pdfGenerator.generateItinerary(filePath ,reservation);
		emailUtil.sendItinerary(passenger.getEmail(),filePath);
		return reservation;
		
	}
	
	

}
