# Lab 1: Object-Oriented Notification System

## Objective

This lab focuses on applying core object-oriented programming concepts in Java, including interfaces, inheritance, and polymorphism. Students will also gain experience setting up a professional Java toolchain using IntelliJ and Maven, and writing unit tests using JUnit 5.

By the end of this lab, students should be able to:

- Define and implement Java interfaces and concrete classes
- Use inheritance and the decorator pattern to extend functionality
- Set up a Maven-based Java project in IntelliJ
- Write and run automated tests using JUnit 5
- Understand how to structure and test a simple notification system

## Lab Tasks and Instructions

### Setup

1. Install Java 17, IntelliJ IDEA, and Maven as outlined in the toolchain setup guide (macOS/Windows).
2. Clone or download the starter code repository.
3. Open the project in IntelliJ and ensure that Maven recognizes the `pom.xml` file.

### Part 1: Interface and Basic Implementations

1. Define a `Notifier` interface with the method:
   ```java
   void send(String message);
   ```

2. Implement the following classes:
   - `EmailNotifier`
   - `SmsNotifier`
   - `SlackNotifier`

   Each class should output a message to the console simulating a notification.

### Part 2: Decorator Implementations

Implement additional classes that extend `Notifier`:

- `LoggingNotifier`: logs the message before sending
- `RetryingNotifier`: simulates retrying failed messages
- `CompositeNotifier`: sends the same message to multiple notifiers

### Part 3: Notification Service

Implement a `NotificationService` class that uses a `Notifier` instance to send a predefined welcome message (e.g., "Welcome to CS-UY 3913").

### Part 4: Testing

1. Create a `FakeNotifier` implementation for testing purposes. It should record whether a message was sent.
2. Write a JUnit 5 test for `NotificationService.sendWelcome()` using `FakeNotifier`.
3. Verify that the message is correctly "sent" using assertions.

### Part 5: Build and Run

1. Ensure that `mvn clean test` runs successfully from the terminal.
2. Use IntelliJ to run the application and confirm the expected console output.

## Project Structure

```
src/
├── main/java/notifier/
│   ├── Notifier.java
│   ├── EmailNotifier.java
│   ├── SmsNotifier.java
│   ├── SlackNotifier.java
│   ├── LoggingNotifier.java
│   ├── RetryingNotifier.java
│   ├── CompositeNotifier.java
│   └── NotificationService.java
└── test/java/notifier/
    └── NotificationServiceTest.java
```

---

## Submission Instructions (Gradescope)

### Before You Submit

**Your code MUST pass `mvn clean test` locally before submitting.**

```bash
mvn clean test
```

If this fails on your machine, it will fail on Gradescope.

### What to Submit

Submit a **zip file** containing your Java source files from `src/main/java/notifier/`.

### Required Files

Your submission must include these 8 files:

| File | Description |
|------|-------------|
| `Notifier.java` | Interface |
| `EmailNotifier.java` | Part 1 |
| `SmsNotifier.java` | Part 1 |
| `SlackNotifier.java` | Part 1 |
| `LoggingNotifier.java` | Part 2 |
| `RetryingNotifier.java` | Part 2 |
| `CompositeNotifier.java` | Part 2 |
| `NotificationService.java` | Part 3 |

### How to Create Your Submission Zip

**Option 1: Zip the notifier folder**
```bash
cd your-project/src/main/java
zip -r submission.zip notifier/
```

**Option 2: Zip just the Java files**
```bash
cd your-project/src/main/java/notifier
zip submission.zip *.java
```

**Option 3: From IntelliJ**
1. Right-click the `notifier` folder in `src/main/java/`
2. Select "Compress" or "Create Archive"
3. Upload the resulting zip file

### Grading (100 Points Total)

| Test | Component | Points |
|------|-----------|--------|
| `testEmailNotifierSendsMessage` | EmailNotifier | 10 |
| `testSmsNotifierSendsMessage` | SmsNotifier | 10 |
| `testSlackNotifierSendsMessage` | SlackNotifier | 10 |
| `testLoggingNotifierLogsBeforeAndAfter` | LoggingNotifier | 10 |
| `testRetryingNotifierSuccess` | RetryingNotifier | 10 |
| `testCompositeNotifierSendsToAll` | CompositeNotifier | 10 |
| `testFakeNotifierRecordsMessage` | FakeNotifier | 10 |
| `testSendWelcomeCallsNotifier` | NotificationService | 10 |
| `testSendWelcomeIncludesUsername` | NotificationService | 10 |
| `testSendWelcomeIncludesWelcome` | NotificationService | 10 |
| **Total** | | **100** |

### Common Errors

| Error Message | Solution |
|---------------|----------|
| "Compilation Failed" | Check for syntax errors. Ensure all files have `package notifier;` at the top. |
| "No test results found" | Make sure `NotificationService` has a `sendWelcome(String userName)` method. |
| "0/100 points" | Your code compiles but tests are failing. Check your implementation logic. |

### Tips

- All classes must be in the `notifier` package (`package notifier;`)
- `NotificationService` must have a constructor that accepts a `Notifier`
- `sendWelcome(String userName)` must call `notifier.send()` with a message containing "Welcome" and the user's name
- Each notifier should print output in the specified format (e.g., `[EMAIL]`, `[SMS]`, `[SLACK]`)

---

## Deliverables

- All classes implemented and compiling
- `mvn clean test` passes successfully
- Code follows OOP principles covered in class
