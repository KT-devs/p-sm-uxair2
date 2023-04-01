package ru.uxair.flight.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.flight.entity.Dto.SeatTypeDto;
import ru.uxair.flight.entity.SeatType;
import ru.uxair.flight.service.SeatTypeService;
import ru.uxair.flight.util.mapper.SeatTypeMapper;

@RestController
@RequestMapping("/seatTypes")
@RequiredArgsConstructor
public class SeatTypeControllerImpl implements SeatTypeController {

    private final SeatTypeService seatTypeService;

    @Override
    public ResponseEntity<SeatTypeDto> createSeatType(SeatTypeDto seatTypeDto) {
        SeatType seatType = SeatTypeMapper.toEntity(seatTypeDto);
        seatType = seatTypeService.createSeatType(seatType);
        SeatTypeDto createdSeatTypeDto = SeatTypeMapper.toDTO(seatType);
        return new ResponseEntity<>(createdSeatTypeDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SeatTypeDto> updateSeatType(Long id, SeatTypeDto seatTypeDto) {
        SeatType seatType = SeatTypeMapper.toEntity(seatTypeDto);
        seatType = seatTypeService.updateSeatType(id, seatType);
        SeatTypeDto updatedSeatTypeDto = SeatTypeMapper.toDTO(seatType);
        return new ResponseEntity<>(updatedSeatTypeDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SeatTypeDto> getSeatTypeById(Long id) {
        SeatType seatType = seatTypeService.getSeatTypeById(id);
        SeatTypeDto seatTypeDto = SeatTypeMapper.toDTO(seatType);
        return new ResponseEntity<>(seatTypeDto, HttpStatus.OK);
    }
}
