package ru.uxair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.flight.entity.Destination;
import java.util.List;

/**
 * Репозиторий Направления
 */
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    List<Destination> getDestinationByCity(String city);

    List<Destination> getDestinationByCountryName(String countryName);

}
