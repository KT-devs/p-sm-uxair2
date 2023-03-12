package ru.uxair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.uxair.flight.entity.Destination;

/**
 * Репозиторий Направления
 */
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    @Query("select d from Destination d where d.id =: id")
    Destination findById(long id);

    @Query("select d from Destination d where d.city =: city")
    Destination findByCity(String city);

    @Query("select d from Destination d where d.countryName =: countryName")
    Destination findByCountryName(String countryName);

}
