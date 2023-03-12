package ru.uxair.flight.util.mapper;

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
        DestinationDto destinationDto = new DestinationDto();
        destinationDto.setId(destinationEntity.getId());
        destinationDto.setCity(destinationEntity.getCity());
        destinationDto.setCountryName(destinationEntity.getCountryName());
        destinationDto.setCountryCode(destinationEntity.getCountryCode());
        destinationDto.setAirportName(destinationEntity.getAirportName());
        destinationDto.setAirportCode(destinationEntity.getAirportCode());
        destinationDto.setTimezone(destinationEntity.getTimezone());
        return destinationDto;
    }

    /**
     * Метод для конвертации из Dto в Entity
     * @param destinationDto Dto
     * @return Entity
     */
    @Override
    public Destination mapToDestinationEntity(DestinationDto destinationDto) {
        Destination destination = new Destination();
        destination.setId(destinationDto.getId());
        destination.setCity(destinationDto.getCity());
        destination.setCountryName(destinationDto.getCountryName());
        destination.setCountryCode(destinationDto.getCountryCode());
        destination.setAirportName(destinationDto.getAirportName());
        destination.setAirportCode(destinationDto.getAirportCode());
        destination.setTimezone(destinationDto.getTimezone());
        return destination;
    }
}
