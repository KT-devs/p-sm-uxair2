package ru.uxair.flight.entity.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Schema(description = "Сущность билета")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDto {
    @Null
    @Schema(description = "Идентификатор")
    private Long id;
    @NotNull
    @Schema(description = "Пассажир")
    private String passenger;
    @NotNull
    @Schema(description = "Бронирование")
    private String booking;
    @NotNull
    @Schema(description = "Категория места в самолете (бизнес, эконом и т.д...)")
    private String seatCategory;
    @NotNull
    @Schema(description = "Дополнительные сервисы на рейсе")
    private String inFlightServices;
    @NotNull
    @Schema(description = "Стоимость билета")
    private float fare;
    @NotNull
    @Schema(description = "Валюта")
    private String currency;
    @NotNull
    @Schema(description = "Рейс")
    private String flight;
}
