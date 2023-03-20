package ru.uxair.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Сущность Направление
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "city")
    private String city;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_code")
    private int countryCode;
    @Column(name = "airport_name")
    private String airportName;
    @Column(name = "airport_code")
    private int airportCode;
    /**
     * UTC - Всемирное координированное время
     * пример в БД UTC+3 - это Московское
     *             UTC+9:30 - Южная Австралия, Северная территория
     */
    @Column(name = "timezone")
    private String timezone;

}
