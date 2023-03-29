package ru.uxair.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.flight.entity.Aircraft;
import ru.uxair.flight.entity.Dto.AircraftDto;
import ru.uxair.flight.repository.AircraftRepository;
import ru.uxair.flight.util.exceptions.AircraftNotFoundException;
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
    @Transactional
    public void saveAircraft(AircraftDto aircraftDto) {
        aircraftRepository.save(aircraftMapper.mapToAircraftEntity(aircraftDto));
    }

    @Override
    @Transactional
    public void updateAircraft(long id, AircraftDto aircraftDtoUpdate) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new AircraftNotFoundException(Long.toString(id)));
        Aircraft aircraftUpdate = aircraftMapper.mapToAircraftEntity(aircraftDtoUpdate);

        aircraft.setBoardNumber(aircraftUpdate.getBoardNumber());
        aircraft.setStamp(aircraftUpdate.getStamp());
        aircraft.setICAOCode(aircraftUpdate.getICAOCode());
        aircraft.setYearOfRelease(aircraftUpdate.getYearOfRelease());
        aircraft.setSeats(aircraftUpdate.getSeats());

        aircraftRepository.save(aircraft);
    }

    @Override
    @Transactional
    public void deleteAircraft(long id) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new AircraftNotFoundException(Long.toString(id)));
        aircraftRepository.delete(aircraft);
    }

    @Override
    @Transactional(readOnly = true)
    public AircraftDto getAircraftById(long id) {
        return aircraftMapper.mapToAircraftDto(aircraftRepository.findById(id)
                .orElseThrow(() -> new AircraftNotFoundException(Long.toString(id))));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AircraftDto> getAllAircraft() {
        List<AircraftDto> aircraftDtos = aircraftRepository.findAll().stream()
                .map(aircraftMapper::mapToAircraftDto)
                .collect(Collectors.toList());
        if (aircraftDtos.isEmpty()) {
            throw new AircraftNotFoundException();
        }
        return aircraftDtos;
    }

}
