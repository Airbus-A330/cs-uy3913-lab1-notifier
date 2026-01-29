# Lab 1: Object-Oriented Notification System

## Objective

This lab focuses on applying core object-oriented programming concepts in Java, including interfaces, inheritance, and polymorphism. Students will also gain experience setting up a professional Java toolchain using IntelliJ and Maven, and writing unit tests using JUnit 5.

By the end of this lab, you will be able to:

- Define and implement Java interfaces and concrete classes
- Use inheritance and the decorator pattern to extend functionality
- Set up a Maven-based Java project in IntelliJ
- Write and run automated tests using JUnit 5
- Understand how to structure and test a simple notification system

---

## Section 1: Setup

Follow these steps to get started with the lab:

### Install the Required Tools

- **Java 17**
- **IntelliJ IDEA**
- **Apache Maven**

Refer to the toolchain setup guides for installation instructions:
- [Toolchain Setup Windows](https://docs.google.com/document/d/your-windows-guide)
- [Toolchain Setup macOS](https://docs.google.com/document/d/your-macos-guide)

### Clone the Starter Code Repository

```bash
git clone https://github.com/bblackheart013/cs-uy3913-lab1-notifier.git
cd cs-uy3913-lab1-notifier
```

### Open the Project in IntelliJ

1. Open IntelliJ, select "Open" and navigate to the cloned folder.
2. Ensure that IntelliJ recognizes the `pom.xml` file as a Maven project.
3. Let Maven finish indexing and resolving dependencies.

---

## Section 2: Part 1 – Interface and Basic Implementations

In this part, you'll begin implementing the basic notifier classes.

### Step 1: Define the Interface

Create the `Notifier.java` file inside `src/main/java/notifier/` with the following content:

```java
package notifier;

public interface Notifier {
    void send(String message);
}
```

### Step 2: Implement These Three Classes

Each class must implement `Notifier` and simulate sending a message via a different channel.

Create the following files in the same directory:

- `EmailNotifier.java`
- `SmsNotifier.java`
- `SlackNotifier.java`

Each class should print output in this format:

```java
// EmailNotifier
[EMAIL] Sending to someone@example.com: Hello World

// SmsNotifier
[SMS] Sending to +1234567890: Hello World

// SlackNotifier
[SLACK] Posting to #general: Hello World
```

Each class will initially include TODO comments for students to complete.

---

## Section 3: Part 2 – Decorator Implementations

This section introduces the **Decorator Pattern** to extend the behavior of your notifier classes without modifying them directly.

### Step 1: Implement the Following Decorators

Each class must also implement the `Notifier` interface and wrap another `Notifier` instance.

Create the following files in `src/main/java/notifier/`:

**LoggingNotifier.java**
- Logs the message before and after calling the wrapped notifier's `send()`.
- Output:
```
[LOG] Sending message...
[EMAIL] Sending to someone@example.com: Hello World
[LOG] Message sent.
```

**RetryingNotifier.java**
- Wraps a notifier and simulates retry logic (can retry once on failure — stubbed behavior for now).

**CompositeNotifier.java**
- Holds a list of notifiers and broadcasts the message to all of them.

### Constructor Examples

```java
// LoggingNotifier wraps another notifier
Notifier email = new EmailNotifier();
Notifier logger = new LoggingNotifier(email);

// CompositeNotifier takes a list of notifiers
List<Notifier> notifiers = List.of(new EmailNotifier(), new SmsNotifier(), new SlackNotifier());
Notifier composite = new CompositeNotifier(notifiers);
```

These classes are also partially stubbed with TODO comments for students to implement.

---

## Section 4: Part 3 – Notification Service

This section ties everything together by creating a simple service that uses a `Notifier` to send a welcome message.

### Step 1: Implement NotificationService.java

Create this file inside:
```
src/main/java/notifier/NotificationService.java
```

Your class should:

1. Have a constructor that accepts a `Notifier`:
```java
public NotificationService(Notifier notifier) { ... }
```

2. Implement a method:
```java
public void sendWelcome(String userName)
```

This method should:
- Compose a welcome message using the student's name (e.g., "Welcome, Alice!")
- Call `notifier.send(message)`

### Example Usage

```java
Notifier notifier = new EmailNotifier("alice@example.com");
NotificationService service = new NotificationService(notifier);
service.sendWelcome("Alice");
```

**Tip:** The autograder includes multiple tests verifying:
- That the message contains both "Welcome" and the student's name
- That the `send()` method is actually invoked

---

## Section 5: Part 4 – Testing with JUnit 5

This section introduces test-driven development by validating your implementation with automated tests.

### Step 1: Implement FakeNotifier

Create the file:
```
src/main/java/notifier/FakeNotifier.java
```

This class should:
- Implement the `Notifier` interface
- Record whether `send()` was called
- Store the last message sent

Example structure:

```java
public class FakeNotifier implements Notifier {
    private boolean called = false;
    private String lastMessage;

    @Override
    public void send(String message) {
        called = true;
        lastMessage = message;
    }

    public boolean wasCalled() {
        return called;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
```

You may also create a simpler version as an inner class in your test file if you prefer.

### Step 2: Verify NotificationService

The file:
```
src/test/java/notifier/NotificationServiceTest.java
```

is already written for you.

⚠️ **DO NOT MODIFY THIS FILE.**

It contains 10 tests that the autograder uses to assign points.

These tests include:
- All notifier subclasses (Email, SMS, Slack)
- Decorators (Logging, Retrying, Composite)
- FakeNotifier functionality
- The output of `NotificationService.sendWelcome`

### Step 3: Run All Tests

In your terminal:

```bash
mvn clean test
```

You should see:

```
Tests run: 10, Failures: 0, Errors: 0
BUILD SUCCESS
```

Or from IntelliJ:
1. Right-click `src/test/java`
2. Click **Run 'All Tests'**

---

## Section 6: Part 5 – Build and Submit to Gradescope

This section ensures your project builds correctly and guides you through submission.

### Step 1: Confirm Build Works

Open a terminal in your project root and run:

```bash
mvn clean test
```

Expected result (after implementation):

```
Tests run: 10, Failures: 0, Errors: 0
BUILD SUCCESS
```

If you see `BUILD FAILURE`, check the error messages or visit the Troubleshooting section.

### Step 2: Create Your Submission ZIP

You must submit only your source code—not the whole project.

From the project root, use one of the following:

**Option 1: Zip the notifier folder (Recommended)**
```bash
cd src/main/java
zip -r submission.zip notifier/
```

**Option 2: Zip the .java files only**
```bash
cd src/main/java/notifier
zip submission.zip *.java
```

**Option 3: From IntelliJ / Finder**
1. Right-click `src/main/java/notifier`
2. Click "Compress" or "Create Archive"

### Step 3: Submit on Gradescope

1. Visit: [gradescope.com](https://gradescope.com)
2. Open the **CS-UY 3913 – Lab 1** assignment
3. Click **Submit**
4. Upload your ZIP file
5. Click **Test Autograder**
6. Check your score — full credit is **100/100**

---

## Section 7: Troubleshooting & FAQ

This section helps you resolve common setup, build, and submission issues. If you're stuck, read this carefully before reaching out.

### IntelliJ Issues

| Problem | Solution |
|---------|----------|
| Project not recognized as Maven | Right-click `pom.xml` → "Add as Maven Project" |
| Red underlines everywhere | File → Invalidate Caches / Restart |
| Cannot resolve symbol 'Notifier' | Ensure `package notifier;` is present in every `.java` file |
| Tests not discovered | Right-click `src/test/java` → Mark Directory as → Test Sources Root |

### Java SDK Issues

| Problem | Fix |
|---------|-----|
| "Java SDK not configured" | File → Project Structure → SDKs → Choose Java 17 |
| Wrong Java version | Ensure `JAVA_HOME` points to Java 17 |
| `mvn` command not found | Install Maven & add to your system PATH |

### Maven Build Errors

| Error | Cause / Fix |
|-------|-------------|
| Compilation failure | Check for typos or missing semicolons |
| Cannot find symbol | Make sure all classes are in `notifier` package |
| Test failures | Open test output to see which assertion failed |
| Dependencies not downloading | Try: `mvn clean install -U` |

### Common Submission Issues

| Mistake | How to Avoid |
|---------|--------------|
| Wrong zip folder | Only zip the `notifier` folder or `.java` files inside it |
| Modifying test file | Do NOT touch `NotificationServiceTest.java` |
| Forgetting `package notifier;` | Add it as the first line in every file |
| Using wrong Java version | Must be Java 17 |

### Still Need Help?

| Support Option | Details |
|----------------|---------|
| Ed Discussion | Post your question under Lab 1 |
| Email | msf9335@nyu.edu |
| Office Hours | Mondays 12–3 PM (Room TBA) |

---

## Section 8: Submission Checklist & Scoring

Before submitting, make sure you've checked every box below. This avoids last-minute grading issues and ensures a smooth autograder run.

### Submission Checklist

| ✅ | Task |
|----|------|
| ☐ | All 9 `.java` files are implemented and placed inside the `notifier/` folder |
| ☐ | All `.java` files include `package notifier;` at the top |
| ☐ | `mvn clean test` passes locally (no red errors, 10 tests pass) |
| ☐ | You did **not** modify `NotificationServiceTest.java` |
| ☐ | You zipped only the `notifier/` folder (no extra folders or nesting) |
| ☐ | Submitted the zip to Gradescope under Lab 1 |
| ☐ | You see a score out of 100 after uploading |
| ☐ | You've read the README.md for lab goals, build help, and tips |

### What the Autograder Tests

| Test | What It Verifies | Points |
|------|------------------|--------|
| `testEmailNotifierSendsMessage` | Console output format for EmailNotifier | 10 |
| `testSmsNotifierSendsMessage` | Console output format for SmsNotifier | 10 |
| `testSlackNotifierSendsMessage` | Console output format for SlackNotifier | 10 |
| `testLoggingNotifierLogsBeforeAndAfter` | Logs + delegation behavior | 10 |
| `testRetryingNotifierSuccess` | Delegation with retry logic | 10 |
| `testCompositeNotifierSendsToAll` | Sends to multiple notifiers | 10 |
| `testFakeNotifierRecordsMessage` | Tracks `send()` call | 10 |
| `testSendWelcomeCallsNotifier` | `sendWelcome()` uses Notifier | 10 |
| `testSendWelcomeIncludesUsername` | Message includes name | 10 |
| `testSendWelcomeIncludesWelcome` | Message includes "Welcome" | 10 |
| **TOTAL** | | **100** |

---

## Project Structure

```
cs-uy3913-lab1-notifier/
├── pom.xml
├── README.md
└── src/
    ├── main/java/notifier/
    │   ├── Notifier.java              ← Interface (provided)
    │   ├── EmailNotifier.java         ← TODO: Implement
    │   ├── SmsNotifier.java           ← TODO: Implement
    │   ├── SlackNotifier.java         ← TODO: Implement
    │   ├── LoggingNotifier.java       ← TODO: Implement
    │   ├── RetryingNotifier.java      ← TODO: Implement
    │   ├── CompositeNotifier.java     ← TODO: Implement
    │   ├── NotificationService.java   ← TODO: Implement
    │   └── FakeNotifier.java          ← TODO: Implement (or use inner class)
    └── test/java/notifier/
        └── NotificationServiceTest.java  ← DO NOT MODIFY
```

---

Good luck! 🚀
