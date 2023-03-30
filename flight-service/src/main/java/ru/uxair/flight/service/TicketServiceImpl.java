package ru.uxair.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Ticket;
import ru.uxair.flight.repository.TicketRepository;
import ru.uxair.flight.util.exceptions.TicketNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException();
        }
        return tickets;

    }

    @Override
    public List<Ticket> getTicketsBySeatCategory(String category) {
        List<Ticket> tickets = ticketRepository.findTicketBySeatCategory(category);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException();
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketByPassenger(String passenger) {
        List<Ticket> tickets = ticketRepository.findAllTicketByPassenger(passenger);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException();
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByFlight(String flight) {
        List<Ticket> tickets = ticketRepository.findTicketByFlight(flight);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException();
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsFareMinToMax() {
        List<Ticket> tickets = ticketRepository.findAllByOrderByFareAsc();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException();
        }
        return tickets;
    }
    @Override
    public List<Ticket> getTicketsFareMaxToMin() {
        List<Ticket> tickets = ticketRepository.findAllByOrderByFareDesc();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException();
        }
        return tickets;
    }
    @Override
    public Ticket findTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElseThrow(TicketNotFoundException::new);
    }

    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
