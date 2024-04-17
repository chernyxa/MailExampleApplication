package com.example.avenueMailExample;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AvenueMailExampleApplication {
    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(AvenueMailExampleApplication.class, args);
    }

    //	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail(){
//		emailService.sendMail(
//				"sergeyspringemail@gmail.com",
//				"sergey.gordeev.000@mail.ru",
//				"This is email subject",
//				"This is email message");
//		System.out.println("Mail sended");
//	}
    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        emailService.sendMailWithAttachment(
                "23igorisakov2002@gmail.com",
                "arafam2@mail.ru",
                "КТо любит Влада",
                "Я люблю Влада",
                "" + "photo_2022-04-21_21-04-35.png");
        System.out.println("Mail with attachment send suncessfuly");
    }

}
