package ru.uxair.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.entity.Dto.DestinationDto;
import ru.uxair.flight.repository.DestinationRepository;
import ru.uxair.flight.util.exceptions.DestinationNotFoundException;
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
    public void saveDestination(DestinationDto destinationDto) {
        destinationRepository.save(destinationMapping.mapToDestinationEntity(destinationDto));
    }

    @Override
    @Transactional
    public void updateDestination(long id, DestinationDto destinationDtoUpdate) {
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException(Long.toString(id)));
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
    @Transactional
    public void deleteDestination(long id) {
        destinationRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException(Long.toString(id)));
        destinationRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public DestinationDto getDestinationById(long id) {
        return destinationMapping.mapToDestinationDto(destinationRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException(Long.toString(id))));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DestinationDto> getDestinationByCity(String city) {
        List<DestinationDto> destinationDtos = destinationRepository.getDestinationByCity(city).stream()
                .map(destinationMapping::mapToDestinationDto)
                .collect(Collectors.toList());
        if (destinationDtos.isEmpty()) {
            throw new DestinationNotFoundException();
        }
        return destinationDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DestinationDto> getDestinationByCountryName(String countryName) {
        List<DestinationDto> destinationDtos = destinationRepository.getDestinationByCountryName(countryName).stream()
                .map(destinationMapping::mapToDestinationDto)
                .collect(Collectors.toList());
        if (destinationDtos.isEmpty()) {
            throw new DestinationNotFoundException();
        }
        return destinationDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DestinationDto> getAllDestination() {
        List<DestinationDto> destinationDtos = destinationRepository.findAll().stream()
                .map(destinationMapping::mapToDestinationDto)
                .collect(Collectors.toList());
        if (destinationDtos.isEmpty()) {
            throw new DestinationNotFoundException();
        }
        return destinationDtos;
    }


}
