package ru.uxair.flight.service;

import ru.uxair.flight.entity.Ticket;

import java.util.List;


public interface TicketService {
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsBySeatCategory(String Category);
    List<Ticket> getTicketByPassenger(String Passenger);
    List<Ticket> getTicketsByFlight(String Flight);
    List<Ticket> getTicketsFareMinToMax();
    List<Ticket> getTicketsFareMaxToMin();
    Ticket findTicketById(Long id);
    Ticket saveTicket(Ticket ticket);
    void deleteTicket(Long id);

}
