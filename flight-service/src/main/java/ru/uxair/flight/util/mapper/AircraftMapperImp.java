package ru.uxair.flight.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Aircraft;
import ru.uxair.flight.entity.Dto.AircraftDto;

@Service
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
