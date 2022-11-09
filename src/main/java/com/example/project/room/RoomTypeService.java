package com.example.project.room;

import java.util.Optional;

import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoomTypeService {
	public final RoomTypeRepository roomTypeRepository;
	
	public RoomType getRoomType(String roomType) {
		Optional<RoomType> rType = this.roomTypeRepository.findByRoomType(roomType);
		
			return rType.get();
		
	}
}
