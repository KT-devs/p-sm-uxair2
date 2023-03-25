package ru.uxair.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.TicketDto;
import ru.uxair.flight.service.TicketService;
import ru.uxair.flight.util.exceptions.TicketNotFoundException;
import ru.uxair.flight.util.mapper.TicketMapper;

import java.util.List;


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
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getAllTickets());
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsBySeatCategory(@PathVariable String category) {
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketsBySeatCategory(category));
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("В категории " + category + " нет билетов");
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketByPassenger(@PathVariable String passenger) {
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketByPassenger(passenger));
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("У пассажира " + passenger + " нет билета");
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketByFlight(@PathVariable String flight) {
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketsByFlight(flight));
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("На рейс " + flight + " нет билетов");
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsFareMinToMax() {
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketsFareMinToMax());
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsFareMaxToMin() {
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketsFareMaxToMin());
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException("Билетов нет");
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TicketDto> findTicketById(@PathVariable Long id) {
        return new ResponseEntity<>(ticketMapper.convertToTicketDto(ticketService.findTicketById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TicketDto> saveTicket(@RequestBody TicketDto ticketDto) {
        ticketService.saveTicket(ticketMapper.convertToTicketEntity(ticketDto));
            return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>("Билет с id "+id+" был удален", HttpStatus.OK);
    }
}
