package ru.uxair.user.service;

import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import ru.uxair.user.entity.Contact;
import ru.uxair.user.repository.ContactRepository;
import ru.uxair.user.util.exceptions.ContactNotFoundException;

import java.util.List;

public class ContactServiceImpl implements ContactService{
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(ContactNotFoundException::new);
    }
}
