package uta.cloud.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uta.cloud.email.entity.Email;
import uta.cloud.email.service.EmailService;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/send")
    String sendRegisterEmail(@RequestBody Email email) {

        String subject = "Register-xxh8517.uta.cloud";

        String text = "Hi, " + email.getUsername() + "\nCongratulations! Your registration is successful.";

        emailService.SendSimpleEmail(email.getAddress(), subject, text);

        return "Email send successful";
    }
}
