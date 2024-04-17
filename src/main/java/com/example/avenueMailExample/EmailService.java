package com.example.avenueMailExample;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

//    public void sendMail(String from,String to,String subject, String message){
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(from);
//        simpleMailMessage.setTo(to);
//        simpleMailMessage.setSubject(subject);
//        simpleMailMessage.setText(message);
//        javaMailSender.send(simpleMailMessage);
//    }

    public void sendMailWithAttachment(String from, String to, String subject, String message, String attachment) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(message);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        javaMailSender.send(mimeMessage);
    }
}
