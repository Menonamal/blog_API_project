package com.flight_reservation_app.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation_app.dto.ReservationUpdateRequest;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.ReservationRepository;

@RestController
public class reservationRESTcontroller {

	@Autowired
	private ReservationRepository reservationRepo;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
	return reservation;
						//http://localhost:8080/flights/reservation/
	}
	
	@RequestMapping("/reservationupdate")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		Reservation reservationupdate = reservationRepo.save(reservation);
		return reservationupdate;
		
}
	
}
