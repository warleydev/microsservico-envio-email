package com.warleydev.emails.services;

import com.warleydev.emails.entities.Email;
import com.warleydev.emails.enums.StatusEmail;
import com.warleydev.emails.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public Email sendEmail(Email entity) {
        entity.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(entity.getEmailFrom());
            message.setTo(entity.getEmailTo());
            message.setSubject(entity.getSubject());
            message.setText(entity.getText());
            emailSender.send(message);

            entity.setStatusEmail(StatusEmail.SENT);
        }
        catch (MailException e){
            entity.setStatusEmail(StatusEmail.ERROR);
        }
        finally {
            return emailRepository.save(entity);
        }
    }
}
