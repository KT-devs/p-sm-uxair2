package ru.uxair1.flight_service.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDto {

    private long id;
    private String city;
    private String countryName;
    private int countryCode;
    private String airportName;
    private int airportCode;
    private LocalDateTime timezone;

}
