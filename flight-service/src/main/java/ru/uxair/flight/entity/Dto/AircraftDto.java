package ru.uxair.flight.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AircraftDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;

    @NotEmpty(message = "Board number should not be empty")
    @Size(min = 5, max = 7, message = "Board number be between 5 and 7 characters")
    private String boardNumber;

    @NotEmpty(message = "Stamp should not be empty")
    @Size(min = 5, max = 50, message = "Stamp should be between 5 and 50 characters")
    private String stamp;

    private String ICAOCode; //DO TO AircraftTypeDto

    @Min(value = 1980, message = "Year of release cannot be less than 1980")
    private int yearOfRelease;

    private String seats; // TO DO Set<SeatDto>

}
