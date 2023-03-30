package ru.uxair.flight.util.mapper;

import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.entity.Dto.DestinationDto;

public interface DestinationMapping {

    DestinationDto mapToDestinationDto(Destination destinationEntity);

    Destination mapToDestinationEntity(DestinationDto destinationDto);
}
