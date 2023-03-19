package ru.uxair.flight.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDto {
    private Long id;
    private String passenger;
    private String booking;
    private String seatCategory;
    private String inFlightServices;
    private float fare;
    private String currency;
    private String flight;
}
