package ru.uxair.flight.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.DestinationDto;
import ru.uxair.flight.service.DestinationService;
import ru.uxair.flight.util.exceptions.DestinationNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Контроллер Направления
 */
@Log4j2
@RestController
public class DestinationControllerIml implements DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationControllerIml(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @Override
    public void saveDestination(DestinationDto destinationDto) {
        log.info("add destination");
        destinationService.saveDestination(destinationDto);
    }

    @Override
    public void updateDestination(long id, DestinationDto destinationDto) {
        log.info("update destination");
        destinationService.updateDestination(id, destinationDto);
    }

    @Override
    public void deleteDestination(long id) {
        log.info("delete destination");
        destinationService.deleteDestination(id);
    }

    @Override
    public DestinationDto getDestinationById(long id) {
        log.info("get destination by id");
        return destinationService.getDestinationById(id);
    }

    @Override
    public List<DestinationDto> getDestinationByCity(String city) {
        log.info("get destination by city");
        return destinationService.getDestinationByCity(city);
    }

    @Override
    public List<DestinationDto> getDestinationByCountryName( String countryName) {
        log.info("get destination by countryName");
        return destinationService.getDestinationByCountryName(countryName);
    }

    @Override
    public List<DestinationDto> getAllDestination() {
        log.info("get all destination");
        return destinationService.getAllDestination();
    }

}
