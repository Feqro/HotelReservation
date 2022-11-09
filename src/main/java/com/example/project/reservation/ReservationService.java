package com.example.project.reservation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.project.DataNotFoundException;
import com.example.project.q_and_a.Question;
import com.example.project.room.Room;
import com.example.project.room.RoomRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	
	public String ReservationDateCheck(ReservationCheck rCheck) {
		Optional<Reservation> roomCheck = 
				this.reservationRepository.findByRoomNoAndCheckInDate(rCheck.getRoomNo(), rCheck.getCheckInDate());
		if(roomCheck.isPresent()) {
			return "impossible";
		}
		
		return "possible";
	}
	
	
	
}
