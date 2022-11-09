package com.example.project.reservation;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ReservationCreate {
	
		
		private String memId;
		
		private String roomNo;
		
		private String roomType;
		
		private LocalDate checkInDate;
		
		private LocalDate checkOutDate;
		
		private int persons;
		
		private int price;
		
		private String pay;
}
