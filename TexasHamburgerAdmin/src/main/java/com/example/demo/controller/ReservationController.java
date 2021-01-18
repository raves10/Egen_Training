package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
public class ReservationController {

	@Autowired
	private ReservationRepo reservationRepo;
	
	@Operation(summary = "Get all reservations")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Reservations found", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Reservation.class)) }),
	  @ApiResponse(responseCode = "204", description = "No content", 
	    content = @Content), 
	  @ApiResponse(responseCode = "500", description = "Internal server error", 
	    content = @Content) })
	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> getAllReservations(@RequestParam(required = false) String name) {
		try {
			
						
			List<Reservation> reservation = new ArrayList<>();

			if (name == null)
				reservationRepo.findAll().forEach(reservation::add);
			else
				reservationRepo.findByCustomerName(name).forEach(reservation::add);

			if (reservation.isEmpty()) {
				log.info("No Reservation found!");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(reservation, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Get reservation by Id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Reservation found", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Reservation.class)) }),
	  @ApiResponse(responseCode = "404", description = "Not found", 
	    content = @Content) })
	@GetMapping("/reservations/{id}")
	public ResponseEntity<Reservation> getReservationById(@PathVariable("id") String id) {
		Optional<Reservation> reservationData = reservationRepo.findById(id);

		if (reservationData.isPresent()) {
			return new ResponseEntity<>(reservationData.get(), HttpStatus.OK);
		} else {
			log.info("Reservation with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Create reservation")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Reservation created", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Reservation.class)) }),
	  @ApiResponse(responseCode = "500", description = "Internal server error", 
	    content = @Content) })
	@PostMapping("/reservations")
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
		try {
			Reservation _reservation = reservationRepo.save(reservation);
			log.info("New Reservation created!");
			return new ResponseEntity<>(_reservation, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Update Reservation by Id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Reservation updated", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Reservation.class)) }),
	  @ApiResponse(responseCode = "404", description = "Not found", 
	    content = @Content) })
	@PutMapping("/reservations/{id}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable("id") String id, @RequestBody Reservation reservation) {
		Optional<Reservation> reservationData = reservationRepo.findByReservationId(id);

		if (reservationData.isPresent()) {
			Reservation _reservation = reservationData.get();
			_reservation.setCustomerName(reservation.getCustomerName());
			_reservation.setPeopleCount(reservation.getPeopleCount());
			_reservation.setTable(reservation.getTable());
			_reservation.setTime(reservation.getTime());
			return new ResponseEntity<>(reservationRepo.save(_reservation), HttpStatus.OK);
		} else {
			log.info("Reservation with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Delete reservations by Id")
	@ApiResponses(value = { 
	  
	  @ApiResponse(responseCode = "204", description = "No content", 
	    content = @Content), 
	  @ApiResponse(responseCode = "500", description = "Internal server error", 
	    content = @Content) })
	@DeleteMapping("/reservations/{id}")
	public ResponseEntity<HttpStatus> deleteReservation(@PathVariable("id") String id) {
		try {
			reservationRepo.deleteById(id);
			log.info("Reservation with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "Delete all reservation")
	@ApiResponses(value = { 
	  
	  @ApiResponse(responseCode = "204", description = "No content", 
	    content = @Content), 
	  @ApiResponse(responseCode = "500", description = "Internal server error", 
	    content = @Content) })
	@DeleteMapping("/reservations")
	public ResponseEntity<HttpStatus> deleteReservations() {
		try {
			reservationRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
