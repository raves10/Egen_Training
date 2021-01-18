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
import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepo;

import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/api")
@Log4j2
public class MenuController {
	
	@Autowired
	private MenuRepo menuRepo;
	
	@GetMapping("/menus")
	public ResponseEntity<List<Menu>> getAllMenus(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
		try {
												
			List<Menu> menu = new ArrayList<>();

			if(name == null  && category == null)
				menuRepo.findAll().forEach(menu::add);
			else if(category == null)
				menuRepo.findByItemName(name).forEach(menu::add);
			else if(name == null)
				menuRepo.findByCategory(category).forEach(menu::add);

			if (menu.isEmpty()) {
				log.info("No content for Menu!");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(menu, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/menus/{id}")
	public ResponseEntity<Menu> getMenuById(@PathVariable("id") String id) {
		Optional<Menu> menuData = menuRepo.findById(id);

		if (menuData.isPresent()) {
			return new ResponseEntity<>(menuData.get(), HttpStatus.OK);
		} else {
			log.info("Menu with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/menus")
	public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
		try {
			System.out.println(menu.getComboAllowed());
			Menu _menu = menuRepo.save(menu);
			log.info("New menu created!");
			return new ResponseEntity<>(_menu, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/menus/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable("id") String id, @RequestBody Menu menu) {
		Optional<Menu> menuData = menuRepo.findByMenuId(id);

		if (menuData.isPresent()) {
			Menu _menu = menuData.get();
			_menu.setCategory(menu.getCategory());
			_menu.setItemName(menu.getItemName());
			_menu.setItemPrice(menu.getItemPrice());
			_menu.setComboAllowed(menu.getComboAllowed());
			_menu.setComboPrice(menu.getComboPrice());
			return new ResponseEntity<>(menuRepo.save(_menu), HttpStatus.OK);
		} else {
			log.info("Menu with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/menus/{id}")
	public ResponseEntity<HttpStatus> deleteMenu(@PathVariable("id") String id) {
		try {
			menuRepo.deleteById(id);
			log.info("Menu with id: "+id+" not found!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/menus")
	public ResponseEntity<HttpStatus> deleteAllMenus() {
		try {
			menuRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	@GetMapping("/menus/comboAllowed/{combo}")
	public ResponseEntity<List<Menu>> getByCombo(@PathVariable("combo") Boolean combo) {
		try {
			
						
			List<Menu> menu = new ArrayList<>();
			
			menuRepo.findByComboAllowed(combo).forEach(menu::add);
			

			if (menu.isEmpty()) {
				log.info("Menu with combo not found!");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(menu, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

}
