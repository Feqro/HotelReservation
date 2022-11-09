package com.example.project.room;


import java.util.List;


import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoomService {
	private final RoomRepository roomRepository;
	
	
	public List<Room> getList(String roomType){
		
		return this.roomRepository.findByRoomType(roomType);
	}
	

}
