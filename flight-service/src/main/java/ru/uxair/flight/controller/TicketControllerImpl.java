package ru.uxair.flight.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import ru.uxair.flight.entity.Dto.TicketDto;
import ru.uxair.flight.service.TicketService;
import ru.uxair.flight.util.mapper.TicketMapper;

import java.util.List;


@Log4j2
@RestController
public class TicketControllerImpl implements TicketController {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketControllerImpl(TicketService ticketService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }
    @Override
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        log.info("get list all tickets");
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getAllTickets());
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(tickets, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsBySeatCategory(@PathVariable String category) {
        log.info("get list tickets by seat category");
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketsBySeatCategory(category));
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(tickets, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketByPassenger(@PathVariable String passenger) {
        log.info("get list tickets by passenger");
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketByPassenger(passenger));
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(tickets, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketByFlight(@PathVariable String flight) {
        log.info("get list tickets by flight");
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketsByFlight(flight));
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(tickets, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsFareMinToMax() {
        log.info("get list tickets by fare (min to max)");
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketsFareMinToMax());
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(tickets, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsFareMaxToMin() {
        log.info("get list tickets by fare (max to min)");
        List<TicketDto> tickets = ticketMapper.convertToListDto(ticketService.getTicketsFareMaxToMin());
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(tickets, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findTicketById(@PathVariable Long id) {
        log.info("get ticket by id");
        try {
            return new ResponseEntity<>(ticketMapper.convertToTicketDto(ticketService.findTicketById(id)), HttpStatus.OK);
        } catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<TicketDto> saveTicket(@RequestBody TicketDto ticketDto) {
        log.info("save ticket");
        ticketService.saveTicket(ticketMapper.convertToTicketEntity(ticketDto));
            return new ResponseEntity<>(ticketDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {
        log.info("delete ticket");
        try {
            ticketService.deleteTicket(id);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Билет с id "+id+" был удален", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TicketDto> updateTicket(TicketDto ticketDto) {
        log.info("update ticket");
        ticketService.saveTicket(ticketMapper.convertToTicketEntity(ticketDto));
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }
}
