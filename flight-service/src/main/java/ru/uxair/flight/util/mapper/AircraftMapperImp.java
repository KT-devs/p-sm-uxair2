package ru.uxair.flight.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Aircraft;
import ru.uxair.flight.entity.Dto.AircraftDto;

@Service
public class AircraftMapperImp implements AircraftMapper{

    private final ModelMapper modelMapper;

    @Autowired
    public AircraftMapperImp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AircraftDto mapToAircraftDto(Aircraft aircraft) {
        return modelMapper.map(aircraft, AircraftDto.class);
    }

    @Override
    public Aircraft mapToAircraftEntity(AircraftDto aircraftDto) {
        return modelMapper.map(aircraftDto, Aircraft.class);
    }
}
