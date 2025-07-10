# Resilient Email Service (Java)

A simple, robust email sending service using Java that includes retry logic, fallback providers, rate limiting, and idempotency.

---

## Features

-  Retry mechanism with exponential backoff
-  Fallback between mock providers
-  Idempotent email requests (no duplicates)
-  Rate limiting (e.g., 5 emails/minute)
-  Email status tracking

---

##  How to Run

1. Compile the project:
   javac -d out src/com/example/email/*.java

2. Run the application:
   javac -d out src/com/example/email/*.java

3. Run the test cases:
   javac -cp "lib/junit-platform-console-standalone-1.10.0.jar" -d out src/com/example/email/*.java test/com/example/email/*.java
   java -jar lib/junit-platform-console-standalone-1.10.0.jar --class-path out --scan-class-path


## Assumptions

- Uses mock email providers instead of real services.
- Email requests use a unique idempotencyKey.
- Console-based app for simplicity.


## Test Framework

- JUnit 5 (standalone) used for unit testing.
- Tests are located in: test/com/example/email/
