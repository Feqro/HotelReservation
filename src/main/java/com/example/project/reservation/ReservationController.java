package com.example.project.reservation;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.member.Member;
import com.example.project.room.Room;
import com.example.project.room.RoomService;
import com.example.project.room.RoomType;
import com.example.project.room.RoomTypeService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@RequestMapping("/reservation")
@Slf4j
public class ReservationController {
	

	private final ReservationService reservationService;
	private final RoomService roomService;
	private final RoomTypeService roomTypeService;
	
	@GetMapping("/info/{roomType}")
	
	public String reservation(HttpSession session, Model model, 
			@PathVariable("roomType")String roomType, ReservationCreate rCreate) {
		Member member = (Member)session.getAttribute("member");
		List<Room> rList = roomService.getList(roomType);
		RoomType rType = this.roomTypeService.getRoomType(roomType);

		model.addAttribute("member", member);
		model.addAttribute("rList", rList);
		model.addAttribute("rType", rType);
		log.info("roomType :" +roomType);
		log.info("rList :" +rList.get(1).getRoomNo());
		log.info("rType :" +rType.getRoomType());
		
		
		return "reservation/reservation";
	}


	/*@PostMapping("/info/{roomType}")
	
	public String reservation(HttpSession session, Model model, 
			 @Valid Reservation reservation) {
		Member member = (Member)session.getAttribute("member");
		

	
		
		
		return "reservation/reservation";
	}
*/


	


	
	
}
