package uta.cloud.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uta.cloud.email.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    String fromEmailAdr;

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Override
    @Async
    public void SendSimpleEmail(String toEmailAdr, String subject, String text) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(fromEmailAdr);
            //邮件接收人
            simpleMailMessage.setTo(toEmailAdr);
            //邮件主题
            simpleMailMessage.setSubject(subject);
            //邮件内容
            simpleMailMessage.setText(text);

            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
