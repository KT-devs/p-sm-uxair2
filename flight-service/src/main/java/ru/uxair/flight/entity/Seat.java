package ru.uxair.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uxair1.flightService.entity.SeatType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "seat")
public class Seat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aircraftId")
    private Long aircraftId;

    @ManyToOne
    @JoinColumn(name = "seatType")
    private SeatType seatType;


    @Column(name = "seatNumder")
    private String seatNumber;
}