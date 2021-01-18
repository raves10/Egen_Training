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

import com.example.demo.model.Location;
import com.example.demo.repository.LocationRepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
public class LocationController {
	
	@Autowired
	private LocationRepo locationRepo;
	
	@Operation(summary = "Get all locations")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Locations found", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Location.class)) }),
	  @ApiResponse(responseCode = "204", description = "No content", 
	    content = @Content), 
	  @ApiResponse(responseCode = "500", description = "Internal server error", 
	    content = @Content) })
	@GetMapping("/locations")
	public ResponseEntity<List<Location>> getAllLocations(@RequestParam(required = false) String name) {
		try {
						
			List<Location> location = new ArrayList<>();

			if (name == null)
				locationRepo.findAll().forEach(location::add);
			else
				locationRepo.findByName(name).forEach(location::add);

			if (location.isEmpty()) {
				log.info("No locations founds!");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(location, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Get location by Id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Location found", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Location.class)) }),
	  @ApiResponse(responseCode = "204", description = "No content", 
	    content = @Content)})
	@GetMapping("/locations/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable("id") String id) {
		Optional<Location> locationData = locationRepo.findById(id);

		if (locationData.isPresent()) {
			return new ResponseEntity<>(locationData.get(), HttpStatus.OK);
		} else {
			log.info("Location with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Create Location")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Location created", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Location.class)) }),
	 @ApiResponse(responseCode = "500", description = "Internal server error", 
	    content = @Content) })
	@PostMapping("/locations")
	public ResponseEntity<Location> createLocation(@RequestBody Location location) {
		try {
			Location _location = locationRepo.save(location);
			log.info("New Location created!");
			return new ResponseEntity<>(_location, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Update location by Id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Locations updated", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Location.class)) }),
	 @ApiResponse(responseCode = "404", description = "Not found", 
	    content = @Content) })
	@PutMapping("/locations/{id}")
	public ResponseEntity<Location> updateLocation(@PathVariable("id") String id, @RequestBody Location location) {
		Optional<Location> locationData = locationRepo.findByLocId(id);

		if (locationData.isPresent()) {
			Location _location = locationData.get();
			_location.setName(location.getName());
			_location.setLatitude(location.getLatitude());
			_location.setLongitude(location.getLongitude());
			_location.setContact(location.getContact());
			return new ResponseEntity<>(locationRepo.save(_location), HttpStatus.OK);
		} else {
			log.info("Location with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Delete location by Id")
	@ApiResponses(value = { 
	  
	  @ApiResponse(responseCode = "204", description = "Location deleted", 
	    content = @Content), 
	  @ApiResponse(responseCode = "500", description = "Internal server error", 
	    content = @Content) })
	@DeleteMapping("/locations/{id}")
	public ResponseEntity<HttpStatus> deleteLocation(@PathVariable("id") String id) {
		try {
			locationRepo.deleteById(id);
			log.info("Location with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "Delete all locations")
	@ApiResponses(value = { 
	 
	  @ApiResponse(responseCode = "204", description = "All locations deleted", 
	    content = @Content), 
	  @ApiResponse(responseCode = "500", description = "Internal server error", 
	    content = @Content) })
	@DeleteMapping("/locations")
	public ResponseEntity<HttpStatus> deleteAllLocations() {
		try {
			locationRepo.deleteAll();
			log.info("Location not found!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
