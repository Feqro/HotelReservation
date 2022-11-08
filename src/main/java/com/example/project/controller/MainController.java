package com.example.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.member.Member;




@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String main() {
		return "main/main";
	}

	@GetMapping("/hotelinfo")
	public String hotelinfo() {
		return "main/hotelinfo";
	}
	
	@GetMapping("/roominfo")
	public String roominfo() {
		return "main/roominfo";
	}
	
	@GetMapping("/map")
	public String map() {
		return "main/map";
	}
	
}
