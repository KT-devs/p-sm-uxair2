package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Dto.TicketDto;
import ru.uxair.flight.util.MarkerDto;

import javax.validation.Valid;
import java.util.List;
@Validated
@Tag(name = "Билет", description = "API управления билетами")
@RequestMapping("/api/flight-service/ticket")
public interface TicketController {
    @Operation(summary = "Список ввсех билетов",
            description = "Получить список всех билетов из БД")
    @GetMapping
    ResponseEntity<List<TicketDto>> getAllTickets();
    @Operation(summary = "Список билетов по категории",
            description = "Список билетов по категории (бизнес, эконом и т.д...)")
    @GetMapping("/category/{category}")
    ResponseEntity<List<TicketDto>> getTicketsBySeatCategory(@PathVariable String category);
    @Operation(summary = "Получить билеты по пассажиру",
            description = "Получить все билеты определенного пассажира")
    @GetMapping("/passenger/{passenger}")
    ResponseEntity<List<TicketDto>> getTicketByPassenger(@PathVariable String passenger);
    @Operation(summary = "Билеты по рейсу",
            description = "Получить все билеты определенного рейса")
    @GetMapping("/flight/{flight}")
    ResponseEntity<List<TicketDto>> getTicketByFlight(@PathVariable String flight);
    @Operation(summary = "Список билетов сортированный МИН-МАКС стоимость",
            description = "Получить список билетов отсортированный от минимальной к максимальной цене")
    @GetMapping("/sortMinToMax")
    ResponseEntity<List<TicketDto>> getTicketsFareMinToMax();
    @Operation(summary = "Список билетов сортированный МАКС-МИН стоимость",
            description = "Получить список билетов отсортированный от максимальной к мнимальной цене")
    @GetMapping("/sortMaxToMin")
    ResponseEntity<List<TicketDto>> getTicketsFareMaxToMin();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @Operation(summary = "Поиск билета по ID")
    @GetMapping("/{id}")
    ResponseEntity<?> findTicketById(@PathVariable Long id);
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Object already exists") })
    @Operation(summary = "Сохранить билет в БД")
    @PostMapping("/save")
    @Validated({MarkerDto.OnCreate.class})
    ResponseEntity<TicketDto> saveTicket(@Valid @RequestBody TicketDto ticketDto);
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @Operation(summary = "Удалить билет из БД")
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTicket(@PathVariable Long id);
    @Operation(summary = "Изменить билет")
    @PutMapping("/update")
    @Validated({MarkerDto.OnUpdate.class})
    ResponseEntity<TicketDto> updateTicket (@Valid @RequestBody TicketDto ticketDto);
}
