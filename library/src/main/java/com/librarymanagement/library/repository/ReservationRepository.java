package com.librarymanagement.library.repository;

import com.librarymanagement.library.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
