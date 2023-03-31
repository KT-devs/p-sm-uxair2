package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.AircraftDto;
import ru.uxair.flight.entity.Dto.ErrorResponseDto;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/aircraft")
@Tag(name = "Воздушное судно", description = "Взаимодействует с воздушным судном")
public interface AircraftController {

    @Operation(summary = "Добавление воздушного судна", description = "Позволяет добавить воздушное судно в бд")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AircraftDto.class))}),
            @ApiResponse(responseCode = "400", description = "Неверные данные",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})})
    @PostMapping
    void saveAircraft(@Valid @RequestBody AircraftDto aircraftDto);

    @Operation(summary = "Обновление воздушного судна", description = "Позволяет обновить воздушное судно в бд")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AircraftDto.class))}),
            @ApiResponse(responseCode = "400", description = "Неверные данные",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})})
    @PatchMapping("/{id}")
    void updateAircraft(@PathVariable @Parameter(description = "Идентификатор воздушного судна") long id, @Valid @RequestBody AircraftDto aircraftDto);

    @Operation(summary = "Удаление воздушного судна", description = "Позволяет удалить воздушное судно в бд")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AircraftDto.class))}),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})})
    @DeleteMapping("/{id}")
    void deleteAircraft(@PathVariable @Parameter(description = "Идентификатор воздушного судна") long id);

    @Operation(summary = "Получение воздушного судна по id", description = "Позволяет получить воздушное судно по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AircraftDto.class))}),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping("/{id}")
    AircraftDto getDestinationById(@PathVariable @Parameter(description = "Идентификатор направления") long id);

    @Operation(summary = "Получение всех воздушных судов", description = "Позволяет получить все воздушные судна")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AircraftDto.class))}),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping
    List<AircraftDto> getAllAircraft();

}
