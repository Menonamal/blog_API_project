package com.flight_reservation_app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight_reservation_app.entity.Flights;



public interface FlightRepository extends JpaRepository<Flights, Long> {
	@Query("from Flights where departureCity =:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flights> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);

   // List<Flights> findByDepartureCityAndArrivalCityAndDateOfDeparture(String departureCity, String arrivalCity, Date dateOfDeparture);

}
