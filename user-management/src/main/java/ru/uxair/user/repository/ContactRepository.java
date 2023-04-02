package ru.uxair.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.uxair.user.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
