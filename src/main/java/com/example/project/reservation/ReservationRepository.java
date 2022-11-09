package com.example.project.reservation;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	Optional<Reservation> findByReservationNo(Integer reservationNo);
	Optional<Reservation> findByRoomNoAndCheckInDate(String roomNo, LocalDate checkInDate);
}
