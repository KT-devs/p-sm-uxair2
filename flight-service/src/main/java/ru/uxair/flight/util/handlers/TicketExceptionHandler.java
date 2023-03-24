package ru.uxair.flight.util.handlers;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.uxair.flight.util.exceptions.TicketError;
import ru.uxair.flight.util.exceptions.TicketNotFoundException;
@ControllerAdvice
public class TicketExceptionHandler extends AbstractExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<TicketError> handlerNotFoundTicket(TicketNotFoundException e){
        TicketError ticketError = new TicketError();
        ticketError.setMessage(e.getMessage());
        return new ResponseEntity<>(ticketError, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<TicketError> handlerEmptyResultDataAccess(EmptyResultDataAccessException e){
        TicketError ticketError = new TicketError();
        ticketError.setMessage(e.getMessage());
        return new ResponseEntity<>(ticketError, HttpStatus.NOT_FOUND);
    }
}
