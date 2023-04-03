package ru.uxair.flight.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Dto.SeatDto;
import ru.uxair.flight.entity.Seat;
import ru.uxair.flight.repository.SeatRepository;
import ru.uxair.flight.util.mapper.SeatMapper;


import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;

    @Override
    public SeatDto getSeatById(Long aircraftId) {
        Optional<Seat> seatOptional = seatRepository.findById(aircraftId);
        if (seatOptional.isPresent()) {
            Seat seat = seatOptional.get();
            return SeatMapper.INSTANCE.toDto(seat);
        }
        return null;
    }

    @Override
    public SeatDto createSeat(SeatDto SeatDto) {
        Seat seat = SeatMapper.INSTANCE.toSeat(SeatDto);
        Seat createdSeat = seatRepository.save(seat);
        return SeatMapper.INSTANCE.toDto(createdSeat);
    }

    @Override
    public SeatDto updateSeatById(Long aircraftId, SeatDto SeatDto) {
        Optional<Seat> seatOptional = seatRepository.findById(aircraftId);
        if (seatOptional.isPresent()) {
            Seat seatToUpdate = SeatMapper.INSTANCE.toSeat(SeatDto);
            seatToUpdate.setId(aircraftId);
            Seat updatedSeat = seatRepository.save(seatToUpdate);
            return SeatMapper.INSTANCE.toDto(updatedSeat);
        }
        return null;
    }
}

