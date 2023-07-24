package com.warleydev.emails.consumers;

import com.warleydev.emails.dtos.EmailDTO;
import com.warleydev.emails.entities.Email;
import com.warleydev.emails.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO dto){
        Email entity = new Email();
        BeanUtils.copyProperties(dto,entity);
        emailService.sendEmail(entity);
        System.out.println("Email status: "+entity.getStatusEmail().toString());
    }

}
