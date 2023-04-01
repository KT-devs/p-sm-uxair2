package ru.uxair.flight.util.mapper;

import ru.uxair.flight.entity.Dto.SeatTypeDto;
import ru.uxair.flight.entity.SeatType;

public class SeatTypeMapper {

    public static SeatTypeDto toDTO(SeatType seatType) {
        return SeatTypeDto.builder()
                .id(seatType.getId())
                .category(seatType.getCategory())
                .hasWindow(seatType.isHasWindow())
                .hasAddPlaceForLegs(seatType.isHasAddPlaceForLegs())
                .hasTV(seatType.isHasTV())
                .isAisle(seatType.isAisle())
                .build();
    }

    public static SeatType toEntity(SeatTypeDto seatTypeDTO) {
        return SeatType.builder()
                .id(seatTypeDTO.getId())
                .category(seatTypeDTO.getCategory())
                .hasWindow(seatTypeDTO.isHasWindow())
                .hasAddPlaceForLegs(seatTypeDTO.isHasAddPlaceForLegs())
                .hasTV(seatTypeDTO.isHasTV())
                .isAisle(seatTypeDTO.isAisle())
                .build();
    }
}
