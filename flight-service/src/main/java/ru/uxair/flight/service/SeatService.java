package ru.uxair.flight.service;

import ru.uxair.flight.entity.Dto.SeatDto;


import java.util.List;

public interface SeatService {

    SeatDto getSeatById(Long aircraftId);

    SeatDto createSeat(SeatDto seatDto);

    SeatDto updateSeatById(Long aircraftId, SeatDto SeatDto);
}
