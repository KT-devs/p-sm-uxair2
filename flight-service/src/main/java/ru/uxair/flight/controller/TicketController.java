package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.TicketDto;
import ru.uxair.flight.entity.Dto.MarkerDto;

import javax.validation.Valid;
import java.util.List;
@Validated
@Tag(name = "Билет", description = "API управления билетами")
@RequestMapping("/api/flight-service/ticket")
public interface TicketController {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Список пустой")})
    @Operation(summary = "Список ввсех билетов",
            description = "Получить список всех билетов из БД")
    @GetMapping
    ResponseEntity<List<TicketDto>> getAllTickets();

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Список пустой")})
    @Operation(summary = "Список билетов по категории",
            description = "Список билетов по категории (бизнес, эконом и т.д...)")
    @GetMapping("/category/{category}")
    ResponseEntity<List<TicketDto>> getTicketsBySeatCategory(@PathVariable String category);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Список пустой")})
    @Operation(summary = "Получить билеты по пассажиру",
            description = "Получить все билеты определенного пассажира")
    @GetMapping("/passenger/{passenger}")
    ResponseEntity<List<TicketDto>> getTicketByPassenger(@PathVariable String passenger);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Список пустой")})
    @Operation(summary = "Билеты по рейсу",
            description = "Получить все билеты определенного рейса")
    @GetMapping("/flight/{flight}")
    ResponseEntity<List<TicketDto>> getTicketByFlight(@PathVariable String flight);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Список пустой")})
    @Operation(summary = "Список билетов сортированный МИН-МАКС стоимость",
            description = "Получить список билетов отсортированный от минимальной к максимальной цене")
    @GetMapping("/sortMinToMax")
    ResponseEntity<List<TicketDto>> getTicketsFareMinToMax();

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Список пустой")})
    @Operation(summary = "Список билетов сортированный МАКС-МИН стоимость",
            description = "Получить список билетов отсортированный от максимальной к мнимальной цене")
    @GetMapping("/sortMaxToMin")
    ResponseEntity<List<TicketDto>> getTicketsFareMaxToMin();


    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Указан не верный идентификатор"),
            @ApiResponse(responseCode = "404", description = "Билет не найден")})
    @Operation(summary = "Поиск билета по ID")
    @GetMapping("/{id}")
    ResponseEntity<?> findTicketById(@PathVariable Long id);


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Билет создан"),
            @ApiResponse(responseCode = "400", description = "Неверный ввод"),
            @ApiResponse(responseCode = "409", description = "Такой билет уже существует") })
    @Operation(summary = "Сохранить билет в БД")
    @PostMapping
    ResponseEntity<TicketDto> saveTicket(@Valid @RequestBody TicketDto ticketDto);


    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Указан не верный идентификатор"),
            @ApiResponse(responseCode = "404", description = "Билет не найден")})
    @Operation(summary = "Удалить билет из БД")
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTicket(@PathVariable Long id);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Билет не найден"),
            @ApiResponse(responseCode = "400", description = "Неверный ввод")})
    @Operation(summary = "Изменить билет")
    @PutMapping
    @Validated({MarkerDto.OnUpdate.class})
    ResponseEntity<TicketDto> updateTicket (@Valid @RequestBody TicketDto ticketDto);
}
