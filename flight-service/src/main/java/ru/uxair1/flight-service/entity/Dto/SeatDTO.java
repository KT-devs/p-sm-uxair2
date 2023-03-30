package ru.uxair1.flight-service.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "entity Seat")
public class SeatDTO {
    @Schema (description = "indicator")
    private Long id;
    @Schema(description = "indicator of aircraft")
    private Long aircraftId;
    @Schema(description = "indicator of seatType")
    private ru.uxair1.flight.SeatType seatType;
    @Schema(description = "value of seatNumber")
    private String seatNumber;

    public static SeatDTO fromEntity(ru.uxair1.flight.Seat seat) {
        return SeatDTO.builder()
                .id(seat.getId())
                .aircraftId(seat.getAircraftId())
                .seatType(seat.getSeatType())
                .seatNumber(seat.getSeatNumber())
                .build();
    }

    public ru.uxair1.flight.Seat toEntity() {
        ru.uxair1.flight.Seat seat = new ru.uxair1.flight.Seat();
        seat.setId(id);
        seat.setAircraftId(aircraftId);
        seat.setSeatType(seatType);
        seat.setSeatNumber(seatNumber);
        return seat;
    }
}
