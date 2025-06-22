package com.example.service;

import com.example.dto.ContactRequest;
import com.example.dto.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Override
    public MessageResponse processContactForm(ContactRequest contactRequest) {
        return new MessageResponse("Your message has been sent successfully!");
    }
}