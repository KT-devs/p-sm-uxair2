package ru.uxair.flight.util.mapper;

import org.modelmapper.ModelMapper;
import ru.uxair.flight.entity.Aircraft;
import ru.uxair.flight.entity.Dto.AircraftDto;

public class AircraftMapperImp implements AircraftMapper{

    @Override
    public AircraftDto mapToAircraftDto(Aircraft aircraft) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(aircraft, AircraftDto.class);
    }

    @Override
    public Aircraft mapToAircraftEntity(AircraftDto aircraftDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(aircraftDto, Aircraft.class);
    }
}
