package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Ticket;

import java.util.List;
@Tag(name = "Билет", description = "API управления билетами")
@RequestMapping("/api/flight-service/ticket")
public interface TicketController {
    @Operation(summary = "Список ввсех билетов",
            description = "Получить список всех билетов из БД")
    @GetMapping
    List<Ticket> getAllTickets();
    @Operation(summary = "Список билетов по категории",
            description = "Список билетов по категории (бизнес, эконом и т.д...)")
    @GetMapping("/category/{category}")
    List<Ticket> getTicketsBySeatCategory(@PathVariable String category);
    @Operation(summary = "Получить билеты по пассажиру",
            description = "Получить все билеты определенного пассажира")
    @GetMapping("/passenger/{passenger}")
    List<Ticket> getTicketByPassenger(@PathVariable String passenger);
    @Operation(summary = "Билеты по рейсу",
            description = "Получить все билеты определенного рейса")
    @GetMapping("/flight/{flight}")
    List<Ticket> getTicketByFlight(@PathVariable String flight);
    @Operation(summary = "Список билетов сортированный МИН-МАКС стоимость",
            description = "Получить список билетов отсортированный от минимальной к максимальной цене")
    @GetMapping("/sortMinToMax")
    List<Ticket> getTicketsFareMinToMax();
    @Operation(summary = "Список билетов сортированный МАКС-МИН стоимость",
            description = "Получить список билетов отсортированный от максимальной к мнимальной цене")
    @GetMapping("/sortMaxToMin")
    List<Ticket> getTicketsFareMaxToMin();
    @Operation(summary = "Поиск билета по ID")
    @GetMapping("/{id}")
    Ticket findTicketById(@PathVariable Long id);
    @Operation(summary = "Сохранить билет в БД")
    @PostMapping("/save")
    ResponseEntity<String> saveTicket(@RequestBody Ticket ticket);
    @Operation(summary = "Удалить билет из БД")
    @DeleteMapping("/{id}")
    void deleteTicket(@PathVariable Long id);

}
