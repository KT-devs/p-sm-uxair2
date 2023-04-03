package ru.uxair.flight.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "entity Seat")
public class SeatDto {
    @Schema (description = "indicator")
    private Long id;
    @Schema(description = "indicator of aircraft")
    private Long aircraftId;
    @Schema(description = "indicator of seatType")
    private SeatType seatType;
    @Schema(description = "The number of the seat", example = "A-001")
    @NotBlank(message = "Seat number is mandatory")
    private String seatNumber;

}
