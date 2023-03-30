package ru.uxair.flight.util.handlers;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.webjars.NotFoundException;
import ru.uxair.flight.entity.Dto.ErrorResponseDto;
import ru.uxair.flight.util.exceptions.TicketNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class TicketExceptionHandler extends AbstractExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> handlerNotFoundTicket(TicketNotFoundException e){
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> handlerEmptyResultDataAccess(EmptyResultDataAccessException e){
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> httpMessageNotReadableException(HttpMessageNotReadableException e){
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> constraintViolationException (ConstraintViolationException e){
        return buildErrorResponse(e, HttpStatus.BAD_REQUEST);
    }
}

