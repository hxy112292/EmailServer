package uta.cloud.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uta.cloud.email.entity.Email;
import uta.cloud.email.service.EmailService;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping(value = "/send")
    String sendRegisterEmail(@RequestParam String address, @RequestParam String username) {

        String subject = "Register-xxh8517.uta.cloud";

        String text = "Hi, " + username + "\nCongratulations! Your registration is successful.";

        emailService.SendSimpleEmail(address, subject, text);

        return "Email send successful";
    }
}
