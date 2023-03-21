package ru.uxair.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.flight.entity.Dto.AircraftDto;
import ru.uxair.flight.service.AircraftService;

import java.util.List;

@RestController
public class AircraftControllerImp implements AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftControllerImp(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @Override
    public void saveAircraft(AircraftDto aircraftDto) {
        aircraftService.saveAircraft(aircraftDto);
    }

    @Override
    public void updateAircraft(long id, AircraftDto aircraftDto) {
        aircraftService.updateAircraft(id, aircraftDto);
    }

    @Override
    public void deleteAircraft(long id) {
        aircraftService.deleteAircraft(id);
    }

    @Override
    public AircraftDto getDestinationById(long id) {
        return aircraftService.getAircraftById(id);
    }

    @Override
    public List<AircraftDto> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }
}
