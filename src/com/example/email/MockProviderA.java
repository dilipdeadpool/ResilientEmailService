package com.example.email;
public class MockProviderA implements EmailProvider {
    public boolean sendEmail(EmailRequest request) throws Exception {
        if (Math.random() < 0.5) throw new RuntimeException("Provider A failed");
        System.out.println("Email sent via Provider A to: " + request.getTo());
        return true;
    }

    public String getName() { return "MockProviderA"; }
}