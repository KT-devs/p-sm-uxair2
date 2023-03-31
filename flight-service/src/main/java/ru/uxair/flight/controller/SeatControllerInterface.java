package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair1.flightService.entity.Dto.SeatDto;
import ru.uxair1.flightService.entity.Seat;

@RestController
@RequestMapping("/aircrafts/{aircraftId}/seats")
@Tag(name = "Seat Controller")
interface SeatControllerInterface {

        @PostMapping
        @Operation(tags = "Create seat",summary = "Create new seat for an aircraft")
        @ApiResponses(value = {
                @ApiResponse(responseCode ="201",description = "Seat created successfully"),
                @ApiResponse(responseCode = "400", description = "Invalid request body"),
                @ApiResponse(responseCode = "404", description = "Aircraft not found"),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        ResponseEntity<Seat> createSeat(@PathVariable Long aircraftId, @RequestBody SeatDto seatDto);

        @PutMapping("/{seatId}")
        @Operation( tags = "Update seat", summary = "Update existing seat")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Seat updated successfully"),
                @ApiResponse(responseCode = "400", description = "Invalid request body"),
                @ApiResponse(responseCode = "404", description = "Seat not found"),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        ResponseEntity<Seat> updateSeat(@PathVariable Long aircraftId, @PathVariable Long seatId, @RequestBody SeatDto seatDto);

        @GetMapping("/{seatId}")
        @Operation(tags = "Get seat", summary = "Get seat by id")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Seat retrieved successfully"),
                @ApiResponse(responseCode = "404", description = "Seat not found"),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        ResponseEntity<Seat> getSeat(@PathVariable Long aircraftId, @PathVariable Long seatId);
}