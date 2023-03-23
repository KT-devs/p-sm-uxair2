package ru.uxair.flight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Ticket;

import java.util.List;
@RequestMapping("/api/flight-service/ticket")
public interface TicketController {
    @GetMapping
    List<Ticket> getAllTickets();
    @GetMapping("/category/{category}")
    List<Ticket> getTicketsBySeatCategory(@PathVariable String category);
    @GetMapping("/passenger/{passenger}")
    List<Ticket> getTicketByPassenger(@PathVariable String passenger);
    @GetMapping("/flight/{flight}")
    List<Ticket> getTicketByFlight(@PathVariable String flight);
    @GetMapping("/sortMinToMax")
    List<Ticket> getTicketsFareMinToMax();
    @GetMapping("/sortMaxToMin")
    List<Ticket> getTicketsFareMaxToMin();
    @GetMapping("/{id}")
    Ticket findTicketById(@PathVariable Long id);
    @PostMapping("/save")
    ResponseEntity<String> saveTicket(@RequestBody Ticket ticket);
    @DeleteMapping("/{id}")
    void deleteTicket(@PathVariable Long id);

}
