package ru.uxair.user.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uxair.user.entity.ContactType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private Long id;
    private ContactType contactType;
    private String value;
    private boolean preferredContact;
}
