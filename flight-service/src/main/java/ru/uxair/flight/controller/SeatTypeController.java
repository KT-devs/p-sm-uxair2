package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import ru.uxair.flight.entity.Dto.SeatTypeDto;

@Tag(name = "Seat Types", description = "CRUD operations for seat types")
public interface SeatTypeController {

    @Operation(summary = "Create a new seat type")
    ResponseEntity<SeatTypeDto> createSeatType(@RequestBody @Validated SeatTypeDto seatTypeDto);

    @Operation(summary  = "Update a seat type")
    ResponseEntity<SeatTypeDto> updateSeatType(@PathVariable("id") Long id,
                                               @RequestBody @Validated SeatTypeDto seatTypeDto);
    @Operation(summary  = "Get a seat type by id")
    ResponseEntity<SeatTypeDto> getSeatTypeById(@PathVariable("id") Long id);
}

