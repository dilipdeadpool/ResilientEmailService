package com.example.email;
import java.util.*;

public class RateLimiter {
    private final int limit;
    private final Queue<Long> timestamps = new LinkedList<>();

    public RateLimiter(int limit) {
        this.limit = limit;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        while (!timestamps.isEmpty() && now - timestamps.peek() > 60000) {
            timestamps.poll();
        }
        if (timestamps.size() < limit) {
            timestamps.add(now);
            return true;
        }
        return false;
    }
}
