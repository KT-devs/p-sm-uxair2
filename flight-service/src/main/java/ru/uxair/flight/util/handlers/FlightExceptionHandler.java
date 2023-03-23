package ru.uxair.flight.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.uxair.flight.entity.Dto.ErrorResponseDto;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class FlightExceptionHandler extends AbstractExceptionHandler{

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundExceptionHandler(EntityNotFoundException e) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponseDto> emptyResultDataExceptionHandler(EmptyResultDataAccessException e) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> notFoundExceptionHandler(ConstraintViolationException e) {
        List<String> errorMessages = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return buildErrorResponse(e, errorMessages.toString(), HttpStatus.BAD_REQUEST);
    }
}
