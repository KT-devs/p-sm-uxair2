package ru.uxair.user.service;

import ru.uxair.user.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    void saveContact(Contact contact);
    void deleteContactById(Long id);
    Contact findById(Long id);
}
