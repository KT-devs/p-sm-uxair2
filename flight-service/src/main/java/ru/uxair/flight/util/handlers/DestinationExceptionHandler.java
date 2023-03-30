package ru.uxair.flight.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.uxair.flight.controller.DestinationController;
import ru.uxair.flight.entity.Dto.ErrorResponseDto;
import ru.uxair.flight.util.exceptions.DestinationNotFoundException;

@ControllerAdvice(assignableTypes = DestinationController.class)
public class DestinationExceptionHandler extends AbstractExceptionHandler{

    @ExceptionHandler(DestinationNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundExceptionHandler(DestinationNotFoundException e) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }
}
