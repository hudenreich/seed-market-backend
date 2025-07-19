package com.example.controller;

import com.example.dto.ContactRequest;
import com.example.dto.MessageResponse;
import com.example.service.ContactService;
import jakarta.validation.Valid; // Важный импорт для валидации
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> submitContactForm(@Valid @RequestBody ContactRequest contactRequest) {
<<<<<<< HEAD

=======
        // @Valid гарантирует, что ContactRequest будет провалидирован
>>>>>>> origin/main
        MessageResponse response = contactService.processContactForm(contactRequest);
        return ResponseEntity.ok(response);
    }
}