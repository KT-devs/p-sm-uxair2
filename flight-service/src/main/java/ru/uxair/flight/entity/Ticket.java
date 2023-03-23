package ru.uxair.flight.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Schema(description = "Сущность билета")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
    @Schema(description = "Идентификатор")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Schema(description = "Пассажир")
    @Column(name = "passenger")
    private String passenger;
    @Schema(description = "Бронирование")
    @Column(name = "booking")
    private String booking;
    @Schema(description = "Категория места в самолете (бизнес, эконом и т.д...)")
    @Column(name = "seat_category")
    private String seatCategory;
    @Schema(description = "Дополнительные сервисы на рейсе")
    @Column(name = "in_flight_service")
    private String inflightService;
    @Schema(description = "Стоимость билета")
    @Column(name = "fare")
    private float fare;
    @Schema(description = "Валюта")
    @Column(name = "currency")
    private String currency;
    @Schema(description = "Рейс")
    @Column(name = "flight")
    private String flight;
}
