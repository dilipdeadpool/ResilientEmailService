package com.example.email;
import java.util.UUID;
public class Main {
    public static void main(String[] args) {
        EmailService service = new EmailService();

        EmailRequest request = new EmailRequest(
            "test@example.com",
            "Test Subject",
            "Test Body",
            UUID.randomUUID().toString()
        );

        System.out.println(service.sendEmail(request));
        System.out.println("Status: " + service.getStatus("test@example.com"));
    }
}