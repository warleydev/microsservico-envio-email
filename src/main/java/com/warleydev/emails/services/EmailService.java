package com.warleydev.emails.services;

import com.warleydev.emails.entities.Email;
import com.warleydev.emails.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public void sendEmail(Email entity) {

    }
}
