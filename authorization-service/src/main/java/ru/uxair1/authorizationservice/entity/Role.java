package ru.uxair1.authorizationservice.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String role;

    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }

}

