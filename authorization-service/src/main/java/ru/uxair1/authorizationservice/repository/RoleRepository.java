package ru.uxair1.authorizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair1.authorizationservice.entity.Role;
import ru.uxair1.authorizationservice.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
