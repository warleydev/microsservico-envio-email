package com.warleydev.emails.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {

    @NotBlank
    private String ownerRef;

    @NotBlank
    @Email
    private String emailFrom;

    @NotBlank
    @Email
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

    public EmailDTO(com.warleydev.emails.entities.Email entity){
        ownerRef = entity.getOwnerRef();
        emailFrom = entity.getEmailFrom();
        emailTo = entity.getEmailTo();
        subject = entity.getSubject();
        text = entity.getText();
    }

}
