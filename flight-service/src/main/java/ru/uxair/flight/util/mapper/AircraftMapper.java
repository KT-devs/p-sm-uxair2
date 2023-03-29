package ru.uxair.flight.util.mapper;

import ru.uxair.flight.entity.Aircraft;
import ru.uxair.flight.entity.Dto.AircraftDto;

public interface AircraftMapper {

    AircraftDto mapToAircraftDto(Aircraft aircraft);

    Aircraft mapToAircraftEntity(AircraftDto aircraftDto);

}
