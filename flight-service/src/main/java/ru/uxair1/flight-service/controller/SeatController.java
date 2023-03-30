package ru.uxair1.flight-service.controller;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair1.flightService.entity.Seat;
import ru.uxair1.flightService.entity.SeatCategory;
import ru.uxair1.flightService.service.SeatService;

import java.util.List;

@RestController
@AllArgsConstructor
public class SeatController implements ru.uxair1.flight.SeatControllerInterface {
    private final SeatService seatService;


    @Override
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat createdSeat = seatService.createSeat(seat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeat);
    }

    @Override
    public ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat seat) {
        seat.setId(id);
        Seat updatedSeat = seatService.updateSeat(seat);
        return ResponseEntity.ok(updatedSeat);
    }

    @Override
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }

    @Override
    public ResponseEntity<List<Seat>> getSeatsByFlightId(@PathVariable Long flightId) {
        List<Seat> seats = seatService.getSeatsByFlight(flightId);
        if (seats.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seats);
    }

    @Override
    public ResponseEntity<List<Seat>> getSeatsByFlightAndCategory(@PathVariable Long flightId, @PathVariable SeatCategory category) {
        List<Seat> seats = seatService.getSeatsByFlightIdAndCategory(flightId, category);
        if (seats.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seats);
    }
//    именно про эти 3 метода я и уточнял в mattermost
//
//    @Override
//    public ResponseEntity<Integer> getSoldSeatsCount(@PathVariable Long flightId) {
//        // Implement the logic to get total number of sold seats
//        return ResponseEntity.ok(soldSeats);
//    }
//
//    @Override
//    public ResponseEntity<Integer> getUnsoldSeatsCount(@PathVariable Long flightId) {
//        // Implement the logic to get total number of unsold seats
//        return ResponseEntity.ok(unsoldSeats);
//    }
//
//    @Override
//    public ResponseEntity<List<BoardingPass>> getRegisteredPassengers(@PathVariable Long flightId) {
//        // Implement the logic to get list of registered passengers
//        return ResponseEntity.ok(passengers);
//    }
}


