package ru.uxair1.flight-service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uxair1.flightService.entity.Flight;
import ru.uxair1.flightService.entity.Seat;
import ru.uxair1.flightService.entity.SeatCategory;
import ru.uxair1.flightService.repository.FlightRepository;
import ru.uxair1.flightService.repository.SeatRepository;
import ru.uxair1.flightService.service.SeatService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
private final FlightRepository flightRepository;
    @Override
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public List<Seat> getSeatsByFlightId(Long flightId) {
        return seatRepository.findByFlightId(flightId);
    }
    @Override
    public List<Seat> getSeatsByFlightIdAndCategory(Long flightId, SeatCategory category) {
        return seatRepository.findByFlightIdAndSeatTypeCategory(flightId, category);
    }

    @Override
    public Seat updateSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    @Override
    public Flight getFlightById(Long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);

        return flightOptional.orElse(null);
    }
}
