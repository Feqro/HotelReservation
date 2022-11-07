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
public class SaleInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SEQ")
    @SequenceGenerator(sequenceName = "sale_seq", allocationSize = 1, name = "SALE_SEQ")
    private Integer sale_no;
	
	private String reservation;
	
	private String mem_id;
	
	private String pay;
	
	private LocalDateTime sale_date;
}
