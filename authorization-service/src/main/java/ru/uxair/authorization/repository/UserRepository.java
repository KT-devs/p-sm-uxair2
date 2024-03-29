package ru.uxair.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.uxair.authorization.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u JOIN FETCH u.roles where u.username = :username")
    User findByUsername (String username);
}
