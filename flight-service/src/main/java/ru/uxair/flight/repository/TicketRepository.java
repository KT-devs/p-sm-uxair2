package ru.uxair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.flight.entity.Ticket;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllTicketByPassenger(String passenger);
    List<Ticket> findTicketBySeatCategory(String category);
    List<Ticket> findTicketByFlight(String flight);
    List<Ticket> findAllByOrderByFareAsc();
    List<Ticket> findAllByOrderByFareDesc();
}
