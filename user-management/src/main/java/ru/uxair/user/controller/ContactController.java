package ru.uxair.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.user.entity.Dto.ContactDto;

import java.util.List;
@Tag(name = "Контакт", description = "API управления контактами пользователя")
@RequestMapping("/api/user-management/contacts")
public interface ContactController {
//    @Operation(summary = "Список ввсех контактов",
//            description = "Получить список всех контактов")
//    @GetMapping
//    List<ContactDto> getAllContacts();
    @PostMapping
    ResponseEntity<ContactDto> saveContact(@RequestBody ContactDto contactDto);
    @PutMapping
    ResponseEntity<ContactDto> updateContact(@RequestBody ContactDto contactDto);
    @DeleteMapping
    void deleteContactById(Long id);
    @GetMapping("/{id}")
    ContactDto findById(@PathVariable Long id);
}
