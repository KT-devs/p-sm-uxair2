package ru.uxair.flight.util.mapper;

import org.springframework.stereotype.Component;
import ru.uxair.flight.entity.Dto.SeatDto;
import ru.uxair.flight.entity.Seat;


@Component
public interface SeatMapper {

    SeatMapper INSTANCE = new SeatMapperImpl();

    SeatDto toDto(Seat seat);

    Seat toSeat(SeatDto seatTypeDTO);
}
