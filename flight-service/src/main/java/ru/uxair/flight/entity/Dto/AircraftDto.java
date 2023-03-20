package ru.uxair.flight.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AircraftDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    private int boardNumber;
    private String stamp;
//    private AircraftType ICAOCode;
    private int yearOfRelease;
//    private Set<Seat> seats;

}