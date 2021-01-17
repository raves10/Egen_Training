package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "locations")
@Data
public class Location{
	
	@Id
	private String locId;
	private String name;
	private String latitude;
	private String longitude;
	private Contact contact;

}
