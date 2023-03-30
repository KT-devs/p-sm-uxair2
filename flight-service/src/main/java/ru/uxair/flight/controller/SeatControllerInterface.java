package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair1.flightService.entity.Seat;
import ru.uxair1.flightService.entity.SeatCategory;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@Tag(name = "Seat Controller")
interface SeatControllerInterface {

    @PostMapping("/")
    @Operation(summary = "Create a new seat")
    ResponseEntity<Seat> createSeat(@RequestBody Seat seat);

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing seat")
    ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat seat);


    @GetMapping("/")
    @Operation(summary = "Get all seats")
    ResponseEntity<List<Seat>> getAllSeats();

    @GetMapping("/byFlight/{flightId}")
    @Operation(summary = "Get seats by flight id")
    ResponseEntity<List<Seat>> getSeatsByFlightId(@PathVariable Long flightId);

    @GetMapping("/byFlightAndCategory/{flightId}/{category}")
    @Operation(summary = "Get seats by flight and category")
    ResponseEntity<List<Seat>> getSeatsByFlightAndCategory(@PathVariable Long flightId, @PathVariable SeatCategory category);

//    @GetMapping("/sold/{flightId}")
//    @Operation(summary = "Get total number of sold seats")
//    ResponseEntity<Integer> getSoldSeatsCount(@PathVariable Long flightId);
//
//    @GetMapping("/unsold/{flightId}")
//    @Operation(summary = "Get total number of unsold seats")
//    ResponseEntity<Integer> getUnsoldSeatsCount(@PathVariable Long flightId);
//
//    @GetMapping("/passengers/{flightId}")
//    @Operation(summary = "Get list of registered passengers")
//    ResponseEntity<List<BoardingPass>> getRegisteredPassengers(@PathVariable Long flightId);
}