package com.warleydev.emails.controllers;

import com.warleydev.emails.dtos.EmailDTO;
import com.warleydev.emails.entities.Email;
import com.warleydev.emails.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
        Email entity = new Email();
        BeanUtils.copyProperties(emailDTO, entity);
        emailService.sendEmail(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmailDTO> getEmailById(@PathVariable UUID id){
        EmailDTO dto = new EmailDTO(emailService.getEmailById(id));
        return ResponseEntity.ok(dto);
    }

}
