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
@RequestMapping("/api/flight-service")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return tickets;
    }

    @GetMapping("/tickets/{category}")
    public List<Ticket> getTicketsBySeatCategory(@PathVariable String category) {
        List<Ticket> tickets = ticketService.getTicketsBySeatCategory(category);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("В категории " + category + " нет билетов");
        }
        return tickets;
    }

    @GetMapping("/tickets/{passenger}")
    public List<Ticket> getTicketByPassenger(@PathVariable String passenger) {
        List<Ticket> tickets = ticketService.getTicketByPassenger(passenger);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("У пассажира " + passenger + " нет билета");
        }
        return tickets;
    }

    @GetMapping("/tickets/{flight}")
    public List<Ticket> getTicketByFlight(@PathVariable String flight) {
        List<Ticket> tickets = ticketService.getTicketsByFlight(flight);
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("На рейс " + flight + " нет билетов");
        }
        return tickets;
    }

    @GetMapping("/tickets/sortMinToMax")
    public List<Ticket> getTicketsFareMinToMax() {
        List<Ticket> tickets = ticketService.getTicketsFareMinToMax();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return tickets;
    }

    @GetMapping("/tickets/sortMaxToMin")
    public List<Ticket> getTicketsFareMaxToMin() {
        List<Ticket> tickets = ticketService.getTicketsFareMaxToMin();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return tickets;
    }

    @GetMapping("/tickets/{id}")
    public Ticket findTicketById(@PathVariable Long id) {
        return ticketService.findTicketById(id);
    }

    @PostMapping("/tickets/save")
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

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
