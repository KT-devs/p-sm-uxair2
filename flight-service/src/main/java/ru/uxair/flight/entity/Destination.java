package ru.uxair.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Column(name = "city", nullable = false)
    @Length(min = 1, max = 255)
    private String city;
    @Column(name = "country_name", nullable = false)
    @Length(min = 1, max = 255)
    private String countryName;
    @Column(name = "country_code", nullable = false)
    @Min(1)
    @Max(999)
    private int countryCode;
    @Column(name = "airport_name", unique = true, nullable = false)
    @Length(min = 1, max = 255)
    private String airportName;
    @Column(name = "airport_code", unique = true, nullable = false)
    @Min(1)
    @Max(999)
    private int airportCode;
    /**
     * UTC - Всемирное координированное время
     * пример в БД UTC+3 - это Московское
     *             UTC+9:30 - Южная Австралия, Северная территория
     */
    @Column(name = "timezone", nullable = false)
    @Length(min = 5, max = 9)
    private String timezone;

}
