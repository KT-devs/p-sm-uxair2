package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.AircraftDto;

import java.util.List;

@RequestMapping("/aircraft")
@Tag(name = "Воздушное судно", description = "Взаимодействует с воздушным судном")
public interface AircraftController {

    @PostMapping
    @Operation(summary = "Добавление воздушного судна", description = "Позволяет добавить воздушное судно в бд")
    void saveAircraft(@RequestBody AircraftDto aircraftDto);

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление воздушного судна", description = "Позволяет обновить воздушное судно в бд")
    void updateAircraft(@PathVariable @Parameter(description = "Идентификатор воздушного судна") long id, @RequestBody AircraftDto aircraftDto);

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление воздушного судна", description = "Позволяет удалить воздушное судно в бд")
    void deleteAircraft(@PathVariable @Parameter(description = "Идентификатор воздушного судна") long id);

    @GetMapping("/{id}")
    @Operation(summary = "Получение воздушного судна по id", description = "Позволяет получить воздушное судно по id")
    AircraftDto getDestinationById(@PathVariable @Parameter(description = "Идентификатор направления") long id);

    @GetMapping
    @Operation(summary = "Получение всех воздушных судов", description = "Позволяет получить все воздушные судна")
    List<AircraftDto> getAllAircraft();

}
