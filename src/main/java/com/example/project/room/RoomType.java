package com.example.project.room;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RoomType {
	@Id
	private String room_type;
	
	private String bed_size;
	
	private String persons;
	
	private String room_size;
	
	private String room_view;
	
	private String room_explain;
	
	private int price;
	
}
