package ru.uxair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.uxair.flight.entity.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllTicketByPassenger(String passenger);
    List<Ticket> findTicketBySeatCategory(String category);
    List<Ticket> findTicketByFlight(String flight);
    List<Ticket> findAllByOrderByFareAsc();
    List<Ticket> findAllByOrderByFareDesc();
}
