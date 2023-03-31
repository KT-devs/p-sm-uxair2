package ru.uxair.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "board_number", unique = true, nullable = false)
    private String boardNumber;

    @Column(name = "stamp")
    private String stamp;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "icao", referencedColumnName = "icao")
//    private AircraftType ICAOCode;

    @Column(name = "icao_code")
    private String ICAOCode;

    @Column(name = "year_of_release")
    private int yearOfRelease;

//    @Column(name = "seats")
//    @OneToMany(mappedBy = "aircraft")
//    private Set<Seat> seats;
    private int seats;

}
