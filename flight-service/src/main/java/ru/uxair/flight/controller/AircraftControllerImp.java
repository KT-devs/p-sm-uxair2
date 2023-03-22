package ru.uxair.flight.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.flight.entity.Dto.AircraftDto;
import ru.uxair.flight.service.AircraftService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Log4j2
@RestController
public class AircraftControllerImp implements AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftControllerImp(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @Override
    public void saveAircraft(AircraftDto aircraftDto) {
        log.info("add aircraft");
        aircraftService.saveAircraft(aircraftDto);
    }

    @Override
    public void updateAircraft(long id, AircraftDto aircraftDto) {
        log.info("update aircraft");
        aircraftService.updateAircraft(id, aircraftDto);
    }

    @Override
    public void deleteAircraft(long id) {
        log.info("delete aircraft");
        aircraftService.deleteAircraft(id);
    }

    @Override
    public AircraftDto getDestinationById(long id) {
        log.info("get aircraft by id");
        return aircraftService.getAircraftById(id);
    }

    @Override
    public List<AircraftDto> getAllAircraft() {
        log.info("get all aircraft");
        List<AircraftDto> aircraftDtos = aircraftService.getAllAircraft();
        if (aircraftDtos.isEmpty()) {
            throw new EntityNotFoundException("Unable to find Aircraft");
        }
        return aircraftService.getAllAircraft();
    }
}
