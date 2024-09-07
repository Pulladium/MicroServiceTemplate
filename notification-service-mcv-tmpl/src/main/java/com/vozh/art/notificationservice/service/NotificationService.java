package com.vozh.art.notificationservice.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vozh.art.common.event.DataSentEvent;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.mail.javamail.MimeMessageHelper;


@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final JavaMailSender javaMailSender;

    @KafkaListener(topics = "data-topic")
    public void listen(DataSentEvent dataSentEvent){

        log.info("Recived message from kafka broker, got from data-set topic {}", dataSentEvent);
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("spring.micros.noreplay@mail.com");
            messageHelper.setTo("vozhov.artem1@gmail.com");
            messageHelper.setSubject("You just sent a Data to processing server, and Notification service got it from kafka");
            messageHelper.setText("You are cool");
        };

        try{
            javaMailSender.send(messagePreparator);
            log.info("Email was sent");
        }catch (MailException e){
            throw new RuntimeException("exception sending mail", e);
        }
    }
}
