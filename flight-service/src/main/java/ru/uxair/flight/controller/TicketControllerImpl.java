package ru.uxair.flight.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return new ResponseEntity<>(ticketMapper.convertToListDto(ticketService.getAllTickets()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsBySeatCategory(@PathVariable String category) {
        log.info("get list tickets by seat category");
        return new ResponseEntity<>(ticketMapper.convertToListDto(ticketService.getTicketsBySeatCategory(category)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketByPassenger(@PathVariable String passenger) {
        log.info("get list tickets by passenger");
        return new ResponseEntity<>(ticketMapper.convertToListDto(ticketService.getTicketByPassenger(passenger)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketByFlight(@PathVariable String flight) {
        log.info("get list tickets by flight");
        return new ResponseEntity<>(ticketMapper.convertToListDto(ticketService.getTicketsByFlight(flight)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsFareMinToMax() {
        log.info("get list tickets by fare (min to max)");
        return new ResponseEntity<>(ticketMapper.convertToListDto(ticketService.getTicketsFareMinToMax()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsFareMaxToMin() {
        log.info("get list tickets by fare (max to min)");
        return new ResponseEntity<>(ticketMapper.convertToListDto(ticketService.getTicketsFareMaxToMin()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findTicketById(@PathVariable Long id) {
        log.info("get ticket by id");
        return new ResponseEntity<>(ticketMapper.convertToTicketDto(ticketService.findTicketById(id)), HttpStatus.OK);
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
        ticketService.deleteTicket(id);
        return new ResponseEntity<>("Билет с id "+id+" был удален", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TicketDto> updateTicket(TicketDto ticketDto) {
        log.info("update ticket");
        ticketService.saveTicket(ticketMapper.convertToTicketEntity(ticketDto));
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }
}
