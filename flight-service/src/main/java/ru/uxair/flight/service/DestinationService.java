package ru.uxair.flight.service;

import ru.uxair.flight.entity.Dto.DestinationDto;

import java.util.List;

public interface DestinationService {

    void saveDestination(DestinationDto destinationDto);

    void updateDestination(long id, DestinationDto destinationDtoUpdate);

    void deleteDestination(long id);

    DestinationDto getDestinationById(long id);

    List<DestinationDto> getDestinationByCity(String city);

    List<DestinationDto> getDestinationByCountryName(String countryName);

    List<DestinationDto> getAllDestination();

}
