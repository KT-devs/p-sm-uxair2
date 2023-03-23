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
    @NotEmpty(message = "City should not be empty")
    @Size(min = 1, max = 255, message = "City should be between 1 and 255 characters")
    @Column(name = "city", nullable = false)
    private String city;
    @NotEmpty(message = "Country name should not be empty")
    @Size(min = 1, max = 255, message = "countryName should be between 1 and 255 characters")
    @Column(name = "country_name", nullable = false)
    private String countryName;
    @Min(value = 1, message = "Country code cannot be less than 1")
    @Max(value = 999, message = "Country code cannot be more than 999")
    @Column(name = "country_code", nullable = false)
    private int countryCode;
    @NotEmpty(message = "Airport name should not be empty")
    @Size(min = 1, max = 255, message = "Airport name should be between 1 and 255 characters")
    @Column(name = "airport_name", unique = true, nullable = false)
    private String airportName;
    @Min(value = 1, message = "Airport code cannot be less than 1")
    @Max(value = 999, message = "Airport code cannot be more than 999")
    @Column(name = "airport_code", unique = true, nullable = false)
    private int airportCode;
    /**
     * UTC - Всемирное координированное время
     * пример в БД UTC+3 - это Московское
     *             UTC+9:30 - Южная Австралия, Северная территория
     */
    @NotEmpty(message = "Timezone should not be empty")
    @Size(min = 5, max = 9, message = "Timezone should be between 5 and 9 characters")
    @Column(name = "timezone", nullable = false)
    private String timezone;

}
