package ru.uxair.flight.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.uxair.flight.entity.Dto.SeatDto;
import ru.uxair.flight.service.SeatService;


import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class SeatControllerImpl implements SeatController {

    private final SeatService seatTypeService;

    @Override
    public ResponseEntity<SeatDto> getSeatById( Long aircraftId) {
        SeatDto SeatTypeDto = seatTypeService.getSeatById(aircraftId);
        if (SeatTypeDto != null) {
            return ResponseEntity.ok(SeatTypeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<SeatDto> createSeat( SeatDto SeatTypeDto) {
        SeatDto createdSeatTypeDto = seatTypeService.createSeat(SeatTypeDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdSeatTypeDto.getId()).toUri();
        return ResponseEntity.created(location).body(createdSeatTypeDto);
    }

    @Override
    public ResponseEntity<SeatDto> updateSeat( Long aircraftId,SeatDto SeatDto) {
        SeatDto updatedSeatTypeDto = seatTypeService.updateSeatById(aircraftId, SeatDto);
        if (updatedSeatTypeDto != null) {
            return ResponseEntity.ok(updatedSeatTypeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


