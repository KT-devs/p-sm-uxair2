package ru.uxair.flight.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uxair1.flightService.entity.SeatCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatTypeDto {

    private Long id;
    private SeatCategory category;
    private boolean hasWindow;
    private boolean hasAddPlaceForLegs;
    private boolean hasTV;
    private boolean isAisle;
}
