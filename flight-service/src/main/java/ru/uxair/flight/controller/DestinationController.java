package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.DestinationDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ru.uxair.flight.entity.Dto.ErrorResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/destination")
@Tag(name = "Направление", description = "Взаимодействует с направлением")
public interface DestinationController {

    @Operation(summary = "Добавление направления", description = "Позволяет добавить направление в бд")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Неверные данные",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})})
    @PostMapping
    void saveDestination(@Valid @RequestBody DestinationDto destinationDto);

    @Operation(summary = "Обновление направления", description = "Позволяет обновить направление в бд")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = @Content),
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
    void updateDestination(@PathVariable @Parameter(description = "Идентификатор направления") @NotNull long id, @Valid @RequestBody DestinationDto destinationDto);

    @Operation(summary = "Удаление направления", description = "Позволяет удалить направление в бд")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @DeleteMapping("/{id}")
    void deleteDestination(@PathVariable @Parameter(description = "Идентификатор направления") @NotNull long id);

    @Operation(summary = "Получение направления по id", description = "Позволяет получить направление по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationDto.class))}),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping("/id/{id}")
    DestinationDto getDestinationById(@PathVariable @Parameter(description = "Идентификатор направления") @NotNull long id);

    @Operation(summary = "Получение направления по названию города", description = "Позволяет получить направление по горооду")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationDto.class))}),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping("/city/{city}")
    List<DestinationDto> getDestinationByCity(@PathVariable @Parameter(description = "Название города") @NotBlank String city);

    @Operation(summary = "Получение направления по названию страны", description = "Позволяет получить направление по названию страны")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationDto.class))}),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping("/countryName/{countryName}")
    List<DestinationDto> getDestinationByCountryName(@PathVariable @Parameter(description = "Название страны") @NotBlank String countryName);

    @Operation(summary = "Получение всех направлений", description = "Позволяет получить все направления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationDto.class))}),
            @ApiResponse(responseCode = "404", description = "Объект не найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping
    List<DestinationDto> getAllDestination();

}
