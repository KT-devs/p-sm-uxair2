package ru.uxair.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.user.entity.Dto.ContactDto;
import ru.uxair.user.service.ContactService;
import ru.uxair.user.util.mapper.ContactMapper;

import java.util.List;
@RestController
public class ContactControllerImpl implements ContactController {
    private final ContactService contactService;
    private final ContactMapper contactMapper;
    @Autowired
    public ContactControllerImpl(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

//    @Override
//    public List<ContactDto> getAllContacts() {
//        return contactMapper.convertToListDto(contactService.getAllContacts());
//    }

    @Override
    public ResponseEntity<ContactDto> saveContact(ContactDto contactDto) {
        contactService.saveContact(contactMapper.convertToContactEntity(contactDto));
        return new ResponseEntity<>(contactDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ContactDto> updateContact(ContactDto contactDto) {
        contactService.saveContact(contactMapper.convertToContactEntity(contactDto));
        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }

    @Override
    public void deleteContactById(Long id) {
        contactService.deleteContactById(id);
    }

    @Override
    public ContactDto findById(Long id) {
        return contactMapper.convertToContactDto(contactService.findById(id));
    }
}
