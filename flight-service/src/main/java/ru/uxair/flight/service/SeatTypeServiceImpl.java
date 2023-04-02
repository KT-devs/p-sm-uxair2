package ru.uxair.flight.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Dto.SeatTypeDto;
import ru.uxair.flight.entity.SeatType;
import ru.uxair.flight.repository.SeatTypeRepository;
import ru.uxair.flight.util.mapper.SeatTypeMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatTypeServiceImpl implements SeatTypeService {

    private final SeatTypeRepository seatTypeRepository;

    @Override
    public SeatTypeDto getSeatTypeById(Long seatTypeId) {
        Optional<SeatType> seatTypeOptional = seatTypeRepository.findById(seatTypeId);
        if (seatTypeOptional.isPresent()) {
            SeatType seatType = seatTypeOptional.get();
            return SeatTypeMapper.INSTANCE.toSeatTypeDTO(seatType);
        }
        return null;
    }

    @Override
    public SeatTypeDto createSeatType(SeatTypeDto seatTypeDto) {
        SeatType seatType = SeatTypeMapper.INSTANCE.toSeatType(seatTypeDto);
        SeatType createdSeatType = seatTypeRepository.save(seatType);
        return SeatTypeMapper.INSTANCE.toSeatTypeDTO(createdSeatType);
    }

    @Override
    public SeatTypeDto updateSeatTypeById(Long seatTypeId, SeatTypeDto seatTypeDTO) {
        Optional<SeatType> seatTypeOptional = seatTypeRepository.findById(seatTypeId);
        if (seatTypeOptional.isPresent()) {
            SeatType seatTypeToUpdate = SeatTypeMapper.INSTANCE.toSeatType(seatTypeDTO);
            seatTypeToUpdate.setId(seatTypeId);
            SeatType updatedSeatType = seatTypeRepository.save(seatTypeToUpdate);
            return SeatTypeMapper.INSTANCE.toSeatTypeDTO(updatedSeatType);
        }
        return null;
    }
}

