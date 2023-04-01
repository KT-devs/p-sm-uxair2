package ru.uxair.flight.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.SeatType;
import ru.uxair.flight.repository.SeatTypeRepository;
import ru.uxair.flight.util.exceptions.SeatTypeNotFoundExeption;

@Service
@RequiredArgsConstructor
public class SeatTypeServiceImpl implements SeatTypeService {

    private final SeatTypeRepository seatTypeRepository;

    @Override
    public SeatType createSeatType(SeatType seatType) {
        return seatTypeRepository.save(seatType);
    }

    @Override
    public SeatType updateSeatType(Long id, SeatType seatType) {
        SeatType existingSeatType = seatTypeRepository.findById(id)
                .orElseThrow(() -> new SeatTypeNotFoundExeption("Seat type not found"));
        BeanUtils.copyProperties(seatType, existingSeatType, "id", "category");
        return seatTypeRepository.save(existingSeatType);
    }

    @Override
    public SeatType getSeatTypeById(Long id) {
        return seatTypeRepository.findById(id)
                .orElseThrow(() -> new SeatTypeNotFoundExeption("Seat type not found"));
    }
}
