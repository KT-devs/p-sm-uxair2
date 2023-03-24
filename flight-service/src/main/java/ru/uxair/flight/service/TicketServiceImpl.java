package ru.uxair.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Dto.TicketDto;
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
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getTicketsBySeatCategory(String category) {
        return ticketRepository.findTicketBySeatCategory(category);
    }

    @Override
    public List<Ticket> getTicketByPassenger(String passenger) {
        return ticketRepository.findAllTicketByPassenger(passenger);
    }

    @Override
    public List<Ticket> getTicketsByFlight(String flight) {
        return ticketRepository.findTicketByFlight(flight);
    }

    @Override
    public List<Ticket> getTicketsFareMinToMax() {
        return ticketRepository.findAllByOrderByFareAsc();
    }
    @Override
    public List<Ticket> getTicketsFareMaxToMin() {
        return ticketRepository.findAllByOrderByFareDesc();
    }
    @Override
    public Ticket findTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElseThrow(()-> new TicketNotFoundException("Билет с id "+id+" не найден"));
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
