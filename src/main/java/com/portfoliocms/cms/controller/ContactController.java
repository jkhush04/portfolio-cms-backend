package com.portfoliocms.cms.controller;

import com.portfoliocms.cms.model.ContactMessage;
import com.portfoliocms.cms.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactMessage> submit(@Valid @RequestBody ContactMessage message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.submit(message));
    }
}
