package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "menu")
@Data
public class Menu extends Category {
	
	@Id
	private String menuId;
	private String itemName;
	private String itemPrice;
	private Boolean comboAllowed;
	private String comboPrice ="0.0";


}
