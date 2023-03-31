package ru.uxair.flight.service;

import ru.uxair1.flightService.entity.Dto.SeatDto;
import ru.uxair1.flightService.entity.Seat;

public interface SeatService {

    Seat createSeat(Long aircraftId, SeatDto seatDto);

    Seat updateSeat(Long aircraftId, Long seatId, SeatDto seatDto);

    Seat getSeat(Long aircraftId, Long seatId);
}
