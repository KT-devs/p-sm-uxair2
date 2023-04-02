package ru.uxair.flight.util.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import ru.uxair.flight.entity.Dto.SeatTypeDto;
import ru.uxair.flight.entity.SeatType;

@AllArgsConstructor
class SeatTypeMapperImpl implements SeatTypeMapper {

    private final ModelMapper modelMapper;
    public SeatTypeMapperImpl() {
        this.modelMapper = new ModelMapper();
    }
    @Override
    public SeatTypeDto toSeatTypeDTO(SeatType seatType) {
        return modelMapper.map(seatType, SeatTypeDto.class);
    }

    @Override
    public SeatType toSeatType(SeatTypeDto seatTypeDto) {
        return modelMapper.map(seatTypeDto, SeatType.class);
    }
}
