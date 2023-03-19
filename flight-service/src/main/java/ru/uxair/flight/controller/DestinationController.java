package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.DestinationDto;

import java.util.List;

@RequestMapping("/destination")
@Tag(name = "Направление", description = "Взаимодействует с направлением")
public interface DestinationController {

    @PostMapping
    @Operation(summary = "Добавление направления", description = "Позволяет добавить направление в бд")
    void saveDestination(@RequestBody DestinationDto destinationDto);

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление направления", description = "Позволяет обновить направление в бд")
    void updateDestination(@PathVariable @Parameter(description = "Идентификатор направления") long id, @RequestBody DestinationDto destinationDto);

    @GetMapping("/{id}")
    @Operation(summary = "Получение направления по id", description = "Позволяет получить направление по id")
    DestinationDto getDestinationById(@PathVariable @Parameter(description = "Идентификатор направления") long id);

    @GetMapping("/city/{city}")
    @Operation(summary = "Получение направления по названию города", description = "Позволяет получить направление по горооду")
    List<DestinationDto> getDestinationByCity(@PathVariable @Parameter(description = "Название города") String city);

    @GetMapping("/countryName/{countryName}")
    @Operation(summary = "Получение направления по названию страны", description = "Позволяет получить направление по названию страны")
    List<DestinationDto> getDestinationByCountryName(@PathVariable @Parameter(description = "Название страны") String countryName);

    @GetMapping
    @Operation(summary = "Получение всех направлений", description = "Позволяет получить все направления")
    List<DestinationDto> getAllDestination();

}
