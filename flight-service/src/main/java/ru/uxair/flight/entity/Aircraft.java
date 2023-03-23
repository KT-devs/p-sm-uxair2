package ru.uxair.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @NotEmpty(message = "Board number should not be empty")
    @Size(min = 5, max = 7, message = "Board number should be between 5 and 7 characters")
    @Column(name = "board_number", unique = true, nullable = false)
    private String boardNumber;

    @NotEmpty(message = "Stamp should not be empty")
    @Size(min = 5, max = 50, message = "Stamp should be between 5 and 50 characters")
    @Column(name = "stamp")
    private String stamp;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ICAOCode", referencedColumnName = "ICAOCode")
//    private AircraftType ICAOCode;
    @Column(name = "ICAO_code")
    private String ICAOCode;

    @Min(value = 1980, message = "Year of release cannot be less than 1980")
    @Column(name = "year_of_release")
    private int yearOfRelease;

//    @Column(name = "seats") TO DO
//    @OneToMany(mappedBy = "aircraftId")
//    private Set<Seat> seats;
    private String seats;
}
