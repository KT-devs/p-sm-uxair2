package ru.uxair1.flight_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.uxair1.flight_service.entity.Dto.DestinationDto;
import ru.uxair1.flight_service.service.DestinationServiceImp;
import java.util.List;

// + log + swagger

@RestController
@RequestMapping("/destination")
public class DestinationController {

    private final DestinationServiceImp destinationService;

    @Autowired
    public DestinationController(DestinationServiceImp destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    public void save(@RequestBody DestinationDto destinationDto) {
        destinationService.save(destinationDto);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody DestinationDto destinationDto) {
        destinationService.update(id, destinationDto);
    }

    @GetMapping("/{id}")
    public DestinationDto getById(@PathVariable long id) {
        return destinationService.findById(id);
    }

    @GetMapping("/{city}")
    public DestinationDto getByCity(@PathVariable String city) {
        return destinationService.findByCity(city);
    }

    @GetMapping("/{countryName}")
    public DestinationDto getByCountryName(@PathVariable String countryName) {
        return destinationService.findByCountryName(countryName);
    }

    @GetMapping
    public List<DestinationDto> findAll() {
        return destinationService.findAll();
    }
}
