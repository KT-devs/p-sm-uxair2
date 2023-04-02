package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.SeatTypeDto;


import javax.validation.Valid;

public interface SeatTypeController {

    @Operation(summary = "Get seat type by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            })
    @GetMapping("/seatTypes/{seatTypeId}")
    ResponseEntity<SeatTypeDto> getSeatTypeById(
            @PathVariable Long seatTypeId);

    @Operation(summary = "Create new seat type",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created")
            })
    @PostMapping("/seatTypes")
    ResponseEntity<SeatTypeDto> createSeatType(
            @RequestBody SeatTypeDto SeatTypeDto);

    @Operation(summary = "Update seat type by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            })
    @PutMapping("/seatTypes/{seatTypeId}")
    ResponseEntity<SeatTypeDto> updateSeatTypeById(
            @PathVariable Long seatTypeId,
            @RequestBody SeatTypeDto SeatTypeDto);
}
