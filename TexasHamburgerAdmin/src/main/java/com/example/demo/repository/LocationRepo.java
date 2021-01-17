package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Location;


@Repository
public interface LocationRepo extends MongoRepository<Location, String>{

	List<Location> findByName(String name);
	Optional<Location> findByLocId(String id);
}
