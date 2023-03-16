package ru.uxair.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.authorization.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
