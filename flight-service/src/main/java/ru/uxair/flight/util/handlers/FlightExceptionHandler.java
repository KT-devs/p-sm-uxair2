package ru.uxair.flight.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.uxair.flight.entity.Dto.ErrorResponseDto;
import org.springframework.dao.EmptyResultDataAccessException;
import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;

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

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponseDto> queryExceptionHandler(SQLException e) {
        return buildErrorResponse(e, HttpStatus.BAD_REQUEST);
    }
}
