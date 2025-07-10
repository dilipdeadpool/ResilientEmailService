package com.example.email;
import java.util.*;
import java.util.concurrent.*;

public class EmailService {
    private final List<EmailProvider> providers;
    private final EmailStatusTracker tracker = new EmailStatusTracker();
    private final RateLimiter rateLimiter = new RateLimiter(5); // 5 per minute
    private final Set<String> idempotencyKeys = ConcurrentHashMap.newKeySet();

    public EmailService() {
        providers = List.of(new MockProviderA(), new MockProviderB());
    }

    public String sendEmail(EmailRequest request) {
        if (!rateLimiter.allowRequest()) return "Rate limit exceeded";
        if (idempotencyKeys.contains(request.getIdempotencyKey())) return "Duplicate request";

        for (EmailProvider provider : providers) {
            for (int attempt = 1; attempt <= 3; attempt++) {
                try {
                    if (provider.sendEmail(request)) {
                        idempotencyKeys.add(request.getIdempotencyKey());
                        tracker.track(request.getTo(), "SENT via " + provider.getName());
                        return "Email sent successfully";
                    }
                } catch (Exception e) {
                    try {
                        Thread.sleep((long) Math.pow(2, attempt) * 100);
                    } catch (InterruptedException ignored) {}
                }
            }
        }

        tracker.track(request.getTo(), "FAILED");
        return "All providers failed";
    }

    public String getStatus(String to) {
        return tracker.getStatus(to);
    }
}