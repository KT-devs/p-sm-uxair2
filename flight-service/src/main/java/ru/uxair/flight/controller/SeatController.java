package ru.uxair.flight.controller;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair1.flightService.entity.Dto.SeatDto;
import ru.uxair1.flightService.entity.Seat;
import ru.uxair1.flightService.service.SeatService;

@RestController
@AllArgsConstructor
public class SeatController implements SeatControllerInterface {
    private final SeatService seatService;
@Override
    public ResponseEntity<Seat> createSeat(@PathVariable Long aircraftId, @RequestBody SeatDto seatDto) {
        Seat seat = seatService.createSeat(aircraftId, seatDto);
        return new ResponseEntity<>(seat, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<Seat> updateSeat(@PathVariable Long aircraftId, @PathVariable Long seatId, @RequestBody SeatDto seatDto) {
        Seat seat = seatService.updateSeat(aircraftId, seatId, seatDto);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Seat> getSeat(@PathVariable Long aircraftId, @PathVariable Long seatId) {
        Seat seat = seatService.getSeat(aircraftId, seatId);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }


}


