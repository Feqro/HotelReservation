package com.example.project.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room {
	
	
	@Id
	@Column(unique = true)
	private Integer  room_no;
	
	@Column(length = 200)
	private String room_type;
	

	
}
