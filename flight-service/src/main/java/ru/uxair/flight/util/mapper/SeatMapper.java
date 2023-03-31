package ru.uxair.flight.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.uxair1.flightService.entity.Dto.SeatDto;
import ru.uxair1.flightService.entity.Seat;

@Component
@Mapper(componentModel = "spring")
public interface SeatMapper {

    @Mapping(target = "seatType", source = "seatType.id")
    SeatDto toDTO(Seat seat);

    @Mapping(target = "seatType.id", source = "seatType")
    Seat toEntity(SeatDto seatDto);
}
