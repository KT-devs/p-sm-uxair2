package ru.uxair.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Dto.AircraftDto;
import ru.uxair.flight.repository.AircraftRepository;

import java.util.List;

@Service
public class AircraftServiceImp implements AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftServiceImp(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public void saveAircraft(AircraftDto aircraftDto) {

    }

    void updateAircraft(long id, AircraftDto aircraftDto);

    void deleteAircraft(long id);

    AircraftDto getAircraftById(long id);

    List<AircraftDto> getAllDestination();

}
