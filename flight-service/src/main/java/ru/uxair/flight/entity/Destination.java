package ru.uxair.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;

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

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "country_code", nullable = false)
    private int countryCode;

    @Column(name = "airport_name", unique = true, nullable = false)
    private String airportName;

    @Column(name = "airport_code", unique = true, nullable = false)
    private int airportCode;

    /**
     * UTC - Всемирное координированное время
     * пример в БД UTC+3 - это Московское
     *             UTC+9:30 - Южная Австралия, Северная территория
     */
    @Column(name = "timezone", nullable = false)
    private String timezone;

}
