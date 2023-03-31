package ru.uxair.flight.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uxair1.flightService.entity.Dto.SeatDto;
import ru.uxair1.flightService.entity.Seat;
import ru.uxair1.flightService.repository.SeatRepository;
import ru.uxair1.flightService.util.exceptions.SeatNotFoundExeption;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    @Override
    public Seat createSeat(Long aircraftId, SeatDto seatDto) {
        Seat seat = new Seat();
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setSeatType(seatDto.getSeatType());
        seat.setAircraftId(aircraftId);
        return seatRepository.save(seat);
    }
    @Override
    public Seat updateSeat(Long aircraftId, Long seatId, SeatDto seatDto) {
        Seat seat = seatRepository.findByIdAndAircraftId(aircraftId, seatId)
                .orElseThrow(() -> new SeatNotFoundExeption("Seat not found"));
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setSeatType(seatDto.getSeatType());
        return seatRepository.save(seat);
    }
    @Override
    public Seat getSeat(Long aircraftId, Long seatId) {
        return seatRepository.findByIdAndAircraftId(aircraftId, seatId)
                .orElseThrow(() -> new SeatNotFoundExeption("Seat not found"));
    }
}

