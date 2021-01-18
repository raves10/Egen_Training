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

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
public class LocationController {
	
	@Autowired
	private LocationRepo locationRepo;
	
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
