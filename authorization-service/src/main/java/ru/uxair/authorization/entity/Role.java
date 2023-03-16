package ru.uxair.authorization.entity;

import lombok.Data;

import javax.persistence.*;

// Сущность ролей пользователя
@Entity
@Table(name = "roles")
@Data
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String role;

    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }

}

