package com.example.email;
public class EmailRequest {
    private String to;
    private String subject;
    private String body;
    private String idempotencyKey;

    public EmailRequest(String to, String subject, String body, String idempotencyKey) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.idempotencyKey = idempotencyKey;
    }

    public String getTo() { return to; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public String getIdempotencyKey() { return idempotencyKey; }
}
