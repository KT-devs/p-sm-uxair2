package ru.uxair.user.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "contact_type")
    @Enumerated(EnumType.STRING)
    private ContactType contactType;
    @Column(name = "value")
    private String value;
    @Column(name = "preferred_contact")
    private boolean preferredContact;
}
