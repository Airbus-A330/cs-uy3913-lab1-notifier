package notifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    private String getCapturedOutput() {
        return outputStream.toString().trim();
    }

    // ==================== EmailNotifier Tests (10 points) ====================

    @Test
    @DisplayName("EmailNotifier sends message with correct format")
    void testEmailNotifierSendsMessage() {
        Notifier email = new EmailNotifier("test@example.com");
        email.send("Hello");
        String output = getCapturedOutput();
        assertTrue(output.contains("[EMAIL]"), "Output should contain [EMAIL] tag");
        assertTrue(output.contains("test@example.com"), "Output should contain email address");
        assertTrue(output.contains("Hello"), "Output should contain the message");
    }

    // ==================== SmsNotifier Tests (10 points) ====================

    @Test
    @DisplayName("SmsNotifier sends message with correct format")
    void testSmsNotifierSendsMessage() {
        Notifier sms = new SmsNotifier("+1-555-1234");
        sms.send("Hello SMS");
        String output = getCapturedOutput();
        assertTrue(output.contains("[SMS]"), "Output should contain [SMS] tag");
        assertTrue(output.contains("+1-555-1234"), "Output should contain phone number");
        assertTrue(output.contains("Hello SMS"), "Output should contain the message");
    }

    // ==================== SlackNotifier Tests (10 points) ====================

    @Test
    @DisplayName("SlackNotifier sends message with correct format")
    void testSlackNotifierSendsMessage() {
        Notifier slack = new SlackNotifier("general");
        slack.send("Hello Slack");
        String output = getCapturedOutput();
        assertTrue(output.contains("[SLACK]"), "Output should contain [SLACK] tag");
        assertTrue(output.contains("general"), "Output should contain channel name");
        assertTrue(output.contains("Hello Slack"), "Output should contain the message");
    }

    // ==================== LoggingNotifier Tests (10 points) ====================

    @Test
    @DisplayName("LoggingNotifier logs before and after sending")
    void testLoggingNotifierLogsBeforeAndAfter() {
        FakeNotifier fake = new FakeNotifier();
        Notifier logging = new LoggingNotifier(fake);
        logging.send("Test message");

        String output = getCapturedOutput();
        assertTrue(output.contains("Before") || output.contains("before") || output.contains("[LOG]"),
            "Output should indicate logging before send");
        assertTrue(fake.wasCalled(), "Wrapped notifier should be called");
    }

    // ==================== RetryingNotifier Tests (10 points) ====================

    @Test
    @DisplayName("RetryingNotifier delegates to wrapped notifier on success")
    void testRetryingNotifierSuccess() {
        FakeNotifier fake = new FakeNotifier();
        Notifier retrying = new RetryingNotifier(fake, 3);
        retrying.send("Retry test");

        assertTrue(fake.wasCalled(), "Wrapped notifier should be called");
        assertEquals("Retry test", fake.getLastMessage(), "Message should be passed through");
    }

    // ==================== CompositeNotifier Tests (10 points) ====================

    @Test
    @DisplayName("CompositeNotifier sends to all notifiers")
    void testCompositeNotifierSendsToAll() {
        FakeNotifier fake1 = new FakeNotifier();
        FakeNotifier fake2 = new FakeNotifier();
        FakeNotifier fake3 = new FakeNotifier();

        Notifier composite = new CompositeNotifier(fake1, fake2, fake3);
        composite.send("Broadcast message");

        assertTrue(fake1.wasCalled(), "First notifier should be called");
        assertTrue(fake2.wasCalled(), "Second notifier should be called");
        assertTrue(fake3.wasCalled(), "Third notifier should be called");
        assertEquals("Broadcast message", fake1.getLastMessage());
        assertEquals("Broadcast message", fake2.getLastMessage());
        assertEquals("Broadcast message", fake3.getLastMessage());
    }

    // ==================== FakeNotifier Tests (10 points) ====================

    @Test
    @DisplayName("FakeNotifier records message correctly")
    void testFakeNotifierRecordsMessage() {
        FakeNotifier fake = new FakeNotifier();

        assertFalse(fake.wasCalled(), "Should not be called initially");
        assertNull(fake.getLastMessage(), "Message should be null initially");

        fake.send("Test message");

        assertTrue(fake.wasCalled(), "Should be marked as called");
        assertEquals("Test message", fake.getLastMessage(), "Should store the message");
    }

    // ==================== NotificationService Tests (30 points) ====================

    @Test
    @DisplayName("NotificationService.sendWelcome calls notifier")
    void testSendWelcomeCallsNotifier() {
        FakeNotifier fake = new FakeNotifier();
        NotificationService service = new NotificationService(fake);

        service.sendWelcome("Alice");

        assertTrue(fake.wasCalled(), "Notifier should be called");
    }

    @Test
    @DisplayName("NotificationService.sendWelcome includes username")
    void testSendWelcomeIncludesUsername() {
        FakeNotifier fake = new FakeNotifier();
        NotificationService service = new NotificationService(fake);

        service.sendWelcome("Bob");

        assertTrue(fake.getLastMessage().contains("Bob"), "Message should contain username");
    }

    @Test
    @DisplayName("NotificationService.sendWelcome includes Welcome")
    void testSendWelcomeIncludesWelcome() {
        FakeNotifier fake = new FakeNotifier();
        NotificationService service = new NotificationService(fake);

        service.sendWelcome("Charlie");

        assertTrue(fake.getLastMessage().contains("Welcome"), "Message should contain 'Welcome'");
    }

    // ==================== Helper class for testing ====================

    static class FakeNotifier implements Notifier {
        private boolean called = false;
        private String lastMessage = null;

        @Override
        public void send(String message) {
            this.called = true;
            this.lastMessage = message;
        }

        public boolean wasCalled() {
            return called;
        }

        public String getLastMessage() {
            return lastMessage;
        }
    }
}
