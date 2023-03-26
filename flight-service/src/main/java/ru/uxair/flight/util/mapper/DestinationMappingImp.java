package ru.uxair.flight.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.entity.Dto.DestinationDto;

/**
 * Класс для конвертации Destination(Направления) из Entity в Dto и обратно
 */
@Service
public class DestinationMappingImp implements DestinationMapping {

    private final ModelMapper modelMapper;

    @Autowired
    public DestinationMappingImp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Метод для конвертации из Entity в Dto
     * @param destinationEntity Entity
     * @return Dto
     */
    @Override
    public DestinationDto mapToDestinationDto(Destination destinationEntity) {
        return modelMapper.map(destinationEntity, DestinationDto.class);
    }

    /**
     * Метод для конвертации из Dto в Entity
     * @param destinationDto Dto
     * @return Entity
     */
    @Override
    public Destination mapToDestinationEntity(DestinationDto destinationDto) {
        return modelMapper.map(destinationDto, Destination.class);
    }
}
