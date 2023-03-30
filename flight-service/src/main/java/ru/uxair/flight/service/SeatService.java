package ru.uxair.flight.service

-service.service;

import ru.uxair1.flightService.entity.Dto.SeatDTO;
import ru.uxair1.flightService.entity.Flight;
import ru.uxair1.flightService.entity.Seat;
import ru.uxair1.flightService.entity.SeatCategory;
import ru.uxair1.flightService.repository.SeatRepository;

import java.util.List;

public interface SeatService {


    Seat createSeat(Seat seat);

    List<Seat> getAllSeats();

    List<Seat> getSeatsByFlightId(Long flightId);

    List<Seat> getSeatsByFlightIdAndCategory(Long flightId, SeatCategory category);

    Seat updateSeat(Seat seat);

    void deleteSeat(Long id);

    Flight getFlightById(Long id);
}
