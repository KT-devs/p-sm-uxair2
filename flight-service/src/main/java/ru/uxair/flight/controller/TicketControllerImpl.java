package ru.uxair.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Ticket;
import ru.uxair.flight.service.TicketService;
import ru.uxair.flight.util.exceptions.TicketNotFoundException;

import java.util.List;


@RestController
public class TicketControllerImpl implements TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketControllerImpl(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsBySeatCategory(@PathVariable String category) {
        List<Ticket> tickets = ticketService.getTicketsBySeatCategory(category);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("В категории " + category + " нет билетов");
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketByPassenger(@PathVariable String passenger) {
        List<Ticket> tickets = ticketService.getTicketByPassenger(passenger);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("У пассажира " + passenger + " нет билета");
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketByFlight(@PathVariable String flight) {
        List<Ticket> tickets = ticketService.getTicketsByFlight(flight);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("На рейс " + flight + " нет билетов");
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsFareMinToMax() {
        List<Ticket> tickets = ticketService.getTicketsFareMinToMax();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsFareMaxToMin() {
        List<Ticket> tickets = ticketService.getTicketsFareMaxToMin();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return tickets;
    }

    @Override
    public Ticket findTicketById(@PathVariable Long id) {
        return ticketService.findTicketById(id);
    }

    @Override
    public ResponseEntity<String> saveTicket(@RequestBody Ticket ticket) {
        ResponseEntity<String> entity;
        try {
            ticketService.saveTicket(ticket);
            entity = new ResponseEntity<>("Пользователь сохранен", HttpStatus.OK);
        } catch (RuntimeException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @Override
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
