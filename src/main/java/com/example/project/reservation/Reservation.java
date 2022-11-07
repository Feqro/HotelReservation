package com.example.project.reservation;

import java.time.LocalDateTime;

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
    private Integer reservation_no;
	private String mem_id;
	private String room_no;
	private String room_type;
	private LocalDateTime check_in_date;
	private LocalDateTime check_out_date;
	private String pay_y_n;
	
	
}
