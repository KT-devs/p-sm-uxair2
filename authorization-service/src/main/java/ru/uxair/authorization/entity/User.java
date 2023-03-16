package ru.uxair1.authorizationservice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

// Сущность пользователя
@Entity
@Table(name = "users")
@Data
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Email
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(){
    }
}

