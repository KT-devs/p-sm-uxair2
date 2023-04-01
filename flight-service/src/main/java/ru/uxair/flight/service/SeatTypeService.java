package ru.uxair.flight.service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.uxair.flight.entity.SeatType;

@Tag(name = "Seat Types", description = "CRUD operations for seat types")
public interface SeatTypeService {

    @Operation(summary = "Create a new seat type")
    SeatType createSeatType(SeatType seatType);

    @Operation(summary = "Update a seat type")
    SeatType updateSeatType(Long id, SeatType seatType);

    @Operation(summary = "Get a seat type by id")
    SeatType getSeatTypeById(Long id);
}
