package uta.cloud.email.service;

public interface EmailService {

    void SendSimpleEmail(String toEmailAdr, String subject, String text);
}
