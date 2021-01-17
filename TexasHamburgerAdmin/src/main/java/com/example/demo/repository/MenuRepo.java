package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Menu;


@Repository
public interface MenuRepo  extends MongoRepository<Menu, String>{
	
	List<Menu> findByCategory(String category);
	Optional<Menu> findByMenuId(String id);
	List<Menu> findByItemName(String name);
	List<Menu> findByComboAllowed(Boolean combo);
}
