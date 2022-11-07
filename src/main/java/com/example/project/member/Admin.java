package com.example.project.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {
	
	@Id
	private String admin_id;
	
	@Column(length = 200) 
	private String admin_pw;
	
	@Column(length = 200) 
	private String admin_name;
	
	@Column(length = 200) 
	private String admin_tell;
}
