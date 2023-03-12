package ru.uxair.flight.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Dto Направления
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    private String city;
    private String countryName;
    private int countryCode;
    private String airportName;
    private int airportCode;
    private LocalDateTime timezone;

}
