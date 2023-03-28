package ru.uxair.authorization.service;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.authorization.entity.Role;
import ru.uxair.authorization.entity.User;
import ru.uxair.authorization.repository.RoleRepository;
import ru.uxair.authorization.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // Сохранить нового юзера
    @Override
    @Transactional
    public User saveUser(User user) {
        log.info("Save user {}", user);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    //Сохранить новую роль
    @Override
    @Transactional
    public Role saveRole(Role role) {
        log.info("Save role {}", role);
        return roleRepository.save(role);
    }

    //Вернуть всех пользователей
    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    //Вернуть все роли
    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        log.info("Fetching all roles");
        return roleRepository.findAll();
    }

    //Вернуть пользователя по полю username
    @Override
    @Transactional(readOnly = true)
    public User getUser(String username) {
        log.info("Fetching user by username {}", username);
        return userRepository.findByUsername(username);
    }

    // Вернуть пользователя по id
    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        log.info("Fetching user by id {}", userRepository.findById(id));
        return userRepository.findById(id);
    }

    //Удалить пользователя по id
    @Override
    @Transactional
    public void deleteUser(Long id) {
        log.info("Delete user {}", findById(id));
        userRepository.deleteById(id);
    }

    // Изменить пользователя
    @Override
    @Transactional
    public void updateUser(User user) {
        log.info("User update" + user);
        user.setRoles(user.getRoles());
        userRepository.save(user);
    }

    @Override
    public Optional<User> getByUsername(@NonNull String username) {
        List<User> users = getAll();
        return users.stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUsername(username).orElseThrow();
        return user;
    }
}
