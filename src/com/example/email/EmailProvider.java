package com.example.email;
public interface EmailProvider {
    boolean sendEmail(EmailRequest request) throws Exception;
    String getName();
}