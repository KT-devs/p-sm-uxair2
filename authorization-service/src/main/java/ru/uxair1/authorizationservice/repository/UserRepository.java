package ru.uxair1.authorizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.uxair1.authorizationservice.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String username);
}
