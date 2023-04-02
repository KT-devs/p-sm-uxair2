package ru.uxair.user.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.uxair.user.entity.Contact;
import ru.uxair.user.entity.Dto.ContactDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactMapper {
    private final ModelMapper modelMapper;
    @Autowired
    public ContactMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ContactDto convertToContactDto(Contact contact){
        return modelMapper.map(contact, ContactDto.class);
    }
    public Contact convertToContactEntity(ContactDto contactDto){
        return modelMapper.map(contactDto, Contact.class);
    }
    public List<ContactDto> convertToListDto(List<Contact> contacts){
        return contacts.stream()
                .map(this::convertToContactDto)
                .collect(Collectors.toList());
    }
}
