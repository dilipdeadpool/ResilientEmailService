package com.example.email;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class EmailStatusTracker {
    private final Map<String, String> statusMap = new ConcurrentHashMap<>();

    public void track(String to, String status) {
        statusMap.put(to, status);
    }

    public String getStatus(String to) {
        return statusMap.getOrDefault(to, "UNKNOWN");
    }
}
