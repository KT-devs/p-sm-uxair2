package ru.uxair.authorization.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.uxair.authorization.entity.Role;
import ru.uxair.authorization.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    Role saveRole(Role role);

    List<User> getAll();

    User getUser(String username);

    Optional<User> findById(Long id);

    void deleteUser(Long id);

    void updateUser(User user);

}
