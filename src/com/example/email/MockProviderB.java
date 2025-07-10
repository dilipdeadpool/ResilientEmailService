package com.example.email;
public class MockProviderB implements EmailProvider {
    public boolean sendEmail(EmailRequest request) throws Exception {
        if (Math.random() < 0.5) throw new RuntimeException("Provider B failed");
        System.out.println("Email sent via Provider B to: " + request.getTo());
        return true;
    }

    public String getName() { return "MockProviderB"; }
}
