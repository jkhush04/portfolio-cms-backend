package com.portfoliocms.cms.service;

import com.portfoliocms.cms.model.ContactMessage;
import com.portfoliocms.cms.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ContactService {


    private final ContactMessageRepository contactMessageRepository;
    private final JavaMailSender mailSender;

    @Value("${app.mail.to}")
    private String notifyEmail;

    public ContactService(ContactMessageRepository contactMessageRepository, JavaMailSender mailSender) {
        this.contactMessageRepository = contactMessageRepository;
        this.mailSender = mailSender;
    }


    public ContactMessage submit(ContactMessage incoming){
        incoming.setId(null);
        incoming.setCreatedAt(Instant.now());
        ContactMessage saved=contactMessageRepository.save(incoming);


        try {
            sendNotification(saved);
        } catch (Exception e) {
            System.err.println("Failed to send contact notification email: " + e.getMessage());
        }

        return saved;
    }


    private void sendNotification(ContactMessage msg) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(notifyEmail);
        mail.setSubject("New portfolio contact message from " + msg.getName());
        mail.setText("From: " + msg.getName() + " (" + msg.getEmail() + ")\n\n" + msg.getMessage());
        mailSender.send(mail);
    }
}
