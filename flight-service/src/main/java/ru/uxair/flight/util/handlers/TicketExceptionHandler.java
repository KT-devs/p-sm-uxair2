package ru.uxair.flight.util.handlers;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.webjars.NotFoundException;
import ru.uxair.flight.entity.Dto.ErrorResponseDto;

@ControllerAdvice
public class TicketExceptionHandler extends AbstractExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> handlerNotFoundTicket(NotFoundException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> handlerEmptyResultDataAccess(EmptyResultDataAccessException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> httpMessageNotReadableException(HttpMessageNotReadableException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
