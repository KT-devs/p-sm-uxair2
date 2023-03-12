package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.DestinationDto;
import ru.uxair.flight.service.DestinationService;

import java.util.List;

/**
 * Контроллер Направления
 */
@Log4j2
@RestController
@RequestMapping("/destination")
@Tag(name = "Направление", description = "Взаимодействует с направлением")
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    @Operation(summary = "Добавление направления", description = "Позволяет добавить направление в бд")
    public void save(@RequestBody DestinationDto destinationDto) {
        log.info("add destination");
        destinationService.save(destinationDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление направления", description = "Позволяет обновить направление в бд")
    public void update(@PathVariable @Parameter(description = "Идентификатор направления") long id, @RequestBody DestinationDto destinationDto) {
        log.info("update destination");
        destinationService.update(id, destinationDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение направления", description = "Позволяет получить направление по id")
    public DestinationDto getById(@PathVariable long id) {
        log.info("get destination by id");
        return destinationService.findById(id);
    }

    @GetMapping("/{city}")
    @Operation(summary = "Получение направления", description = "Позволяет получить направление по горооду")
    public DestinationDto getByCity(@PathVariable String city) {
        log.info("get destination by city");
        return destinationService.findByCity(city);
    }

    @GetMapping("/{countryName}")
    @Operation(summary = "Получение направления", description = "Позволяет получить направление по названию страны")
    public DestinationDto getByCountryName(@PathVariable String countryName) {
        log.info("get destination by countryName");
        return destinationService.findByCountryName(countryName);
    }

    @GetMapping
    @Operation(summary = "Получение направления", description = "Позволяет получить все направления")
    public List<DestinationDto> findAll() {
        log.info("get all destination");
        return destinationService.findAll();
    }
}
