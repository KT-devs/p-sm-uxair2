package ru.uxair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.flight.entity.SeatType;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {

}
