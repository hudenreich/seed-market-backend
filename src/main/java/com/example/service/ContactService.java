package com.example.service;

import com.example.dto.ContactRequest;
import com.example.dto.MessageResponse; // Импорт, если используете MessageResponse для ответа

public interface ContactService {
    MessageResponse processContactForm(ContactRequest contactRequest);
}