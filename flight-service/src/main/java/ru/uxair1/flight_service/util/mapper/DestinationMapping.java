package ru.uxair1.flight_service.util.mapper;

import ru.uxair1.flight_service.entity.Destination;
import ru.uxair1.flight_service.entity.Dto.DestinationDto;

public interface DestinationMapping {

    DestinationDto mapToDestinationDto(Destination destinationEntity);

    Destination mapToDestinationEntity(DestinationDto destinationDto);
}
