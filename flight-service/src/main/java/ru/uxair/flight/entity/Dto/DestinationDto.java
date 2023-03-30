package ru.uxair.flight.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @NotEmpty(message = "City should not be empty")
    @Size(min = 1, max = 255, message = "City should be between 1 and 255 characters")
    private String city;

    @NotEmpty(message = "Country name should not be empty")
    @Size(min = 1, max = 255, message = "countryName should be between 1 and 255 characters")
    private String countryName;

    @Min(value = 1, message = "Country code cannot be less than 1")
    @Max(value = 999, message = "Country code cannot be more than 999")
    private int countryCode;

    @NotEmpty(message = "Airport name should not be empty")
    @Size(min = 1, max = 255, message = "Airport name should be between 1 and 255 characters")
    private String airportName;

    @Min(value = 1, message = "Airport code cannot be less than 1")
    @Max(value = 999, message = "Airport code cannot be more than 999")
    private int airportCode;

    @NotEmpty(message = "Timezone should not be empty")
    @Size(min = 5, max = 9, message = "Timezone should be between 5 and 9 characters")
    private String timezone;

}
