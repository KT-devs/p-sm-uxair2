package ru.uxair.flight.entity.Dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uxair.flight.util.MarkerDto;

import javax.validation.constraints.*;

@Schema(description = "Сущность билета")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDto {

    @Null(groups = MarkerDto.OnCreate.class)
    @NotNull(groups = MarkerDto.OnUpdate.class)
    private Long id;
    @NotNull
    @Schema(description = "Пассажир")
    private String passenger;
    @NotNull
    @Schema(description = "Бронирование")
    private String booking;
    @NotEmpty
    @Schema(description = "Категория места в самолете (бизнес, эконом и т.д...)")
    private String seatCategory;
    @NotBlank
    @Schema(description = "Дополнительные сервисы на рейсе")
    private String inFlightServices;
    @NotNull
    @PositiveOrZero
    @Schema(description = "Стоимость билета")
    private float fare;
    @NotNull
    @Schema(description = "Валюта")
    private String currency;
    @NotNull
    @Schema(description = "Рейс")
    private String flight;
}
