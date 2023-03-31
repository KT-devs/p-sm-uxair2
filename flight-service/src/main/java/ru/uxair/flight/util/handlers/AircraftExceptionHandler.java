package ru.uxair.flight.util.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.uxair.flight.entity.Dto.ErrorResponseDto;
import ru.uxair.flight.controller.AircraftController;
import ru.uxair.flight.util.exceptions.AircraftNotFoundException;
import org.springframework.http.HttpStatus;

@ControllerAdvice(assignableTypes = AircraftController.class)
public class AircraftExceptionHandler extends AbstractExceptionHandler{

    @ExceptionHandler(AircraftNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> aircraftNotFoundExceptionHandler(AircraftNotFoundException e) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }
}
