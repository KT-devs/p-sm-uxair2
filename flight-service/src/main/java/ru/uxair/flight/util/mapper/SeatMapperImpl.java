package ru.uxair.flight.util.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;
import ru.uxair.flight.entity.Dto.SeatDto;
import ru.uxair.flight.entity.Seat;

@Component
@AllArgsConstructor
public class SeatMapperImpl implements SeatMapper {

    private final ModelMapper modelMapper;

    public SeatMapperImpl() {
        this.modelMapper = new ModelMapper();
    }
@Override
    public SeatDto toDto(Seat seat) {
        return modelMapper.map(seat, SeatDto.class);
    }
@Override
    public Seat toSeat(SeatDto seatDto) {
        return modelMapper.map(seatDto, Seat.class);
    }
}
