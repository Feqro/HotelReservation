package com.example.project.reservation;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
	
public class ReservationCheck {
	
	private String roomNo;
	
	private LocalDate checkInDate;
}
