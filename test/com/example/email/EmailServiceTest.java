package com.example.email;
import org.junit.jupiter.api.Test;

import com.example.email.EmailRequest;
import com.example.email.EmailService;

import static org.junit.jupiter.api.Assertions.*;

public class EmailServiceTest {

    @Test
    public void testSuccessfulSend() {
        EmailService service = new EmailService();
        EmailRequest request = new EmailRequest(
                "test@example.com",
                "Subject",
                "Body",
                "unique-id-1"
        );

        String result = service.sendEmail(request);
        assertTrue(result.contains("Email sent successfully"));
        assertTrue(service.getStatus("test@example.com").contains("SENT"));
    }

    @Test
    public void testIdempotency() {
        EmailService service = new EmailService();
        String id = "same-id";

        EmailRequest request1 = new EmailRequest("idempotent@example.com", "Sub", "Body", id);
        EmailRequest request2 = new EmailRequest("idempotent@example.com", "Sub", "Body", id);

        service.sendEmail(request1);
        String result = service.sendEmail(request2);

        assertEquals("Duplicate request", result);
    }
}