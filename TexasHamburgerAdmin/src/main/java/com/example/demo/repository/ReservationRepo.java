package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reservation;

@Repository
public interface ReservationRepo extends MongoRepository<Reservation, String>{
	
	List<Reservation> findByCustomerName(String name);
	Optional<Reservation> findByReservationId(String id);

}
