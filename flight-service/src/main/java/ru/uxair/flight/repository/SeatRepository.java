package ru.uxair.flight.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair1.flightService.entity.Seat;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    Optional<Seat> findByIdAndAircraftId(Long id, Long aircraftId);

}