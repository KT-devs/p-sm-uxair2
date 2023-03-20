package ru.uxair.flight.service;

import ru.uxair.flight.entity.Dto.AircraftDto;

import java.util.List;

public interface AircraftService {

    void saveAircraft(AircraftDto aircraftDto);

    void updateAircraft(long id, AircraftDto aircraftDto);

    void deleteAircraft(long id);

    AircraftDto getAircraftById(long id);

    List<AircraftDto> getAllDestination();
}
