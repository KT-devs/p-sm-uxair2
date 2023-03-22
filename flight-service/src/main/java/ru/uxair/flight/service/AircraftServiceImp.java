package ru.uxair.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Aircraft;
import ru.uxair.flight.entity.Dto.AircraftDto;
import ru.uxair.flight.repository.AircraftRepository;
import ru.uxair.flight.util.mapper.AircraftMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftServiceImp implements AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AircraftMapper aircraftMapper;

    @Autowired
    public AircraftServiceImp(AircraftRepository aircraftRepository, AircraftMapper aircraftMapper) {
        this.aircraftRepository = aircraftRepository;
        this.aircraftMapper = aircraftMapper;
    }

    @Override
    public void saveAircraft(AircraftDto aircraftDto) {
        aircraftRepository.save(aircraftMapper.mapToAircraftEntity(aircraftDto));
    }

    public void updateAircraft(long id, AircraftDto aircraftDtoUpate) {
        Aircraft aircraft = aircraftRepository.getReferenceById(id);
        Aircraft aircraftUpdate = aircraftMapper.mapToAircraftEntity(aircraftDtoUpate);
        aircraft.setBoardNumber(aircraftUpdate.getBoardNumber());
        aircraft.setStamp(aircraftUpdate.getStamp());
        aircraft.setICAOCode(aircraftUpdate.getICAOCode());
        aircraft.setYearOfRelease(aircraftUpdate.getYearOfRelease());
        aircraft.setSeats(aircraftUpdate.getSeats());
        aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(long id) {
        aircraftRepository.deleteById(id);
    }

    public AircraftDto getAircraftById(long id) {
        return aircraftMapper.mapToAircraftDto(aircraftRepository.getReferenceById(id));
    }

    public List<AircraftDto> getAllAircraft() {
        return aircraftRepository.findAll().stream()
                .map(aircraftMapper::mapToAircraftDto)
                .collect(Collectors.toList());
    }

}
