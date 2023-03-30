package ru.uxair.authorization.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

//public enum Role implements GrantedAuthority{
//    ROLE_SUPERADMIN("SUPERADMIN"),
//    ROLE_ADMIN("ADMIN"),
//    ROLE_MANAGER("MANAGER"),
//    ROLE_CUSTOMER("CUSTOMER");
//
//    private String value;
//    private Role(String value) {
//        this.value = value;
//    }
//
//    @Override
//    public String getAuthority() {
//        return value;
//    }
//}
@Entity
@Table(name = "roles")
@Data
public class Role {

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
