package ru.uxair.flight.util.mapper;

import org.springframework.stereotype.Component;
import ru.uxair.flight.entity.Dto.SeatTypeDto;
import ru.uxair.flight.entity.SeatType;
@Component
public interface SeatTypeMapper {

    SeatTypeMapper INSTANCE = new SeatTypeMapperImpl();

    SeatTypeDto toSeatTypeDTO(SeatType seatType);

    SeatType toSeatType(SeatTypeDto seatTypeDTO);
}