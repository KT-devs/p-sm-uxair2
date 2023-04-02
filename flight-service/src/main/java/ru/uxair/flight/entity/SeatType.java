package ru.uxair.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "seatType")
public class SeatType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SeatCategory category;

    @Column(name = "hasWindow")
    private boolean hasWindow;

    @Column(name = "hasAddPlaceForLegs")
    private boolean hasAddPlaceForLegs;

    @Column(name = "hasTv")
    private boolean hasTV;

    @Column(name = "isAisle")
    private boolean isAisle;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "seatType")
    private Set<Seat> seats;
}
