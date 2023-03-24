package ru.uxair.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.TicketDto;
import ru.uxair.flight.entity.Ticket;
import ru.uxair.flight.service.TicketService;
import ru.uxair.flight.util.exceptions.TicketNotFoundException;
import ru.uxair.flight.util.mapper.TicketMapper;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TicketControllerImpl implements TicketController {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketControllerImpl(TicketService ticketService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    public ResponseEntity<List<TicketDto>> getAllTickets() {
        List<TicketDto> tickets = ticketService.getAllTickets().
                stream()
                .map(ticketMapper::convertToTicketDto)
                .collect(Collectors.toList());
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
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
    public List<TicketDto> getTicketsFareMinToMax() {
        List<TicketDto> tickets = ticketService.getTicketsFareMinToMax().
                stream()
                .map(ticketMapper::convertToTicketDto)
                .collect(Collectors.toList());
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
    public ResponseEntity<Ticket> saveTicket(@RequestBody TicketDto ticketDto) {
            return new ResponseEntity<>(ticketService.saveTicket(ticketMapper.convertToTicketEntity(ticketDto)), HttpStatus.OK);
    }

    @Override
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
