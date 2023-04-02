package ru.uxair.flight.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.uxair.flight.entity.Dto.SeatTypeDto;
import ru.uxair.flight.service.SeatTypeService;


import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class SeatTypeControllerImpl implements SeatTypeController {

    private final SeatTypeService seatTypeService;

    @Override
    public ResponseEntity<SeatTypeDto> getSeatTypeById( Long seatTypeId) {
        SeatTypeDto SeatTypeDto = seatTypeService.getSeatTypeById(seatTypeId);
        if (SeatTypeDto != null) {
            return ResponseEntity.ok(SeatTypeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<SeatTypeDto> createSeatType( SeatTypeDto SeatTypeDto) {
        SeatTypeDto createdSeatTypeDto = seatTypeService.createSeatType(SeatTypeDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdSeatTypeDto.getId()).toUri();
        return ResponseEntity.created(location).body(createdSeatTypeDto);
    }

    @Override
    public ResponseEntity<SeatTypeDto> updateSeatTypeById( Long seatTypeId,SeatTypeDto SeatTypeDto) {
        SeatTypeDto updatedSeatTypeDto = seatTypeService.updateSeatTypeById(seatTypeId, SeatTypeDto);
        if (updatedSeatTypeDto != null) {
            return ResponseEntity.ok(updatedSeatTypeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
