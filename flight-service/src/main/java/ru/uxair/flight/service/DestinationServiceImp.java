package ru.uxair.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.entity.Dto.DestinationDto;
import ru.uxair.flight.repository.DestinationRepository;
import ru.uxair1.flight_service.util.exceptions.AbstractResourceNotFoundException;
import ru.uxair.flight.util.mapper.DestinationMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис Направления
 */
@Service
public class DestinationServiceImp implements DestinationService {

    private final DestinationRepository destinationRepository;
    private final DestinationMapping destinationMapping;

    @Autowired
    public DestinationServiceImp(DestinationRepository destinationRepository, DestinationMapping destinationMapping) {
        this.destinationRepository = destinationRepository;
        this.destinationMapping = destinationMapping;
    }

    @Override
    @Transactional
    public void save(DestinationDto destinationDto) {
        destinationRepository.save(destinationMapping.mapToDestinationEntity(destinationDto));
    }

    @Override
    @Transactional
    public void update(long id, DestinationDto destinationDtoUpdate) {
        Destination destination = destinationRepository.findById(id);
        Destination destinationUpdate = destinationMapping.mapToDestinationEntity(destinationDtoUpdate);
        destination.setCity(destinationUpdate.getCity());
        destination.setCountryName(destinationUpdate.getCountryName());
        destination.setCountryCode(destinationUpdate.getCountryCode());
        destination.setAirportName(destinationUpdate.getAirportName());
        destination.setAirportCode(destinationUpdate.getAirportCode());
        destination.setTimezone(destinationUpdate.getTimezone());
        destinationRepository.save(destination);
    }

    @Override
    @Transactional(readOnly = true)
    public DestinationDto findById(long id) {
        return destinationMapping.mapToDestinationDto(destinationRepository.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public DestinationDto findByCity(String city) {
        return destinationMapping.mapToDestinationDto(destinationRepository.findByCity(city));
    }

    @Override
    @Transactional(readOnly = true)
    public DestinationDto findByCountryName(String countryName) {
        return destinationMapping.mapToDestinationDto(destinationRepository.findByCountryName(countryName));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DestinationDto> findAll() {
        return destinationRepository.findAll().stream()
                .map(destinationMapping::mapToDestinationDto)
                .collect(Collectors.toList());
    }


}
