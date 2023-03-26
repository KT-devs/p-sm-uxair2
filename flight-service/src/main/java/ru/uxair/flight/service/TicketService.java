package ru.uxair.flight.service;
import ru.uxair.flight.entity.Ticket;
import javax.transaction.Transactional;
import java.util.List;


public interface TicketService {
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsBySeatCategory(String Category);
    List<Ticket> getTicketByPassenger(String Passenger);
    List<Ticket> getTicketsByFlight(String Flight);
    List<Ticket> getTicketsFareMinToMax();
    List<Ticket> getTicketsFareMaxToMin();
    Ticket findTicketById(Long id);
    @Transactional
    void saveTicket(Ticket ticket);
    @Transactional
    void deleteTicket(Long id);


}
