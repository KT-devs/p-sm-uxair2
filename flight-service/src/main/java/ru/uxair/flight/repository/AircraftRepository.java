package ru.uxair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.flight.entity.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}
