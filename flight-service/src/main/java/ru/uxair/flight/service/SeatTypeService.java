package ru.uxair.flight.service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.uxair.flight.entity.Dto.SeatTypeDto;
import ru.uxair.flight.entity.SeatType;

@Tag(name = "Seat Types", description = "CRUD operations for seat types")
public interface SeatTypeService {

    @Operation(summary = "Create a new seat type")
    SeatTypeDto createSeatType(SeatTypeDto seatTypeDto);
    @Operation(summary = "Update a seat type")
    SeatTypeDto updateSeatTypeById(Long seatTypeId, SeatTypeDto seatTypeDto);

    @Operation(summary = "Get a seat type by id")
    SeatTypeDto getSeatTypeById(Long seatTypeId);
}