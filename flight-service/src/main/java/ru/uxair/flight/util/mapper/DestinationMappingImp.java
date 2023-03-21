package ru.uxair.flight.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.entity.Dto.DestinationDto;

/**
 * Класс для конвертации Destination(Направления) из Entity в Dto и обратно
 */
@Service
public class DestinationMappingImp implements DestinationMapping {

    /**
     * Метод для конвертации из Entity в Dto
     * @param destinationEntity Entity
     * @return Dto
     */
    @Override
    public DestinationDto mapToDestinationDto(Destination destinationEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(destinationEntity, DestinationDto.class);
    }

    /**
     * Метод для конвертации из Dto в Entity
     * @param destinationDto Dto
     * @return Entity
     */
    @Override
    public Destination mapToDestinationEntity(DestinationDto destinationDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(destinationDto, Destination.class);
    }
}
