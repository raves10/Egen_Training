package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "reservations")
@Data
public class Reservation {

	@Id
	private String reservationId;
	private String customerName;
	private String peopleCount;
	private String table;
	private String time;
	
	
}
