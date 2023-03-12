package ru.uxair.flight.service;

import ru.uxair.flight.entity.Dto.DestinationDto;

import java.util.List;

public interface DestinationService {

    void save(DestinationDto destinationDto);
    void update(long id, DestinationDto destinationDtoUpdate);
    DestinationDto findById(long id);
    DestinationDto findByCity(String city);
    DestinationDto findByCountryName(String countryName);
    List<DestinationDto> findAll();
}
