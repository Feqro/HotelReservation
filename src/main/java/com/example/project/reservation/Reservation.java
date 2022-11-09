package com.example.project.reservation;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESETVATION_SEQ")
    @SequenceGenerator(sequenceName = "reservation_seq", allocationSize = 1, name = "RESETVATION_SEQ")
    private Integer reservationNo;
	
	private String memId;
	
	private String roomNo;
	
	private String roomType;
	
	private LocalDate checkInDate;
	
	private LocalDate checkOutDate;
	
	private String persons;
	
	private int price;
	
	private String pay;
	
	
}
