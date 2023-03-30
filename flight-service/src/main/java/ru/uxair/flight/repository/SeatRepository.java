package ru.uxair.flight.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair1.flightService.entity.Seat;
import ru.uxair1.flightService.entity.SeatCategory;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByFlightIdAndSeatTypeCategory(Long flightId, SeatCategory category);
}
