package notifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    /**
     * Fake notifier for testing - records messages instead of sending them.
     * TODO: implement this class
     */
    static class FakeNotifier implements Notifier {

        // TODO: add field to track if send() was called
        // TODO: add field to store the last message

        @Override
        public void send(String message) {
            // TODO: record the message
        }

        public boolean wasCalled() {
            // TODO: return true if send() was called
            return false;
        }

        public String getLastMessage() {
            // TODO: return the last message
            return null;
        }
    }

    private FakeNotifier fake;
    private NotificationService service;

    @BeforeEach
    void setUp() {
        fake = new FakeNotifier();
        service = new NotificationService(fake);
    }

    @Test
    void sendWelcome_callsSend() {
        // TODO: call service.sendWelcome("Test")
        // TODO: assert that fake.wasCalled() is true
        fail("implement this test");
    }

    @Test
    void sendWelcome_includesUserName() {
        // TODO: call service.sendWelcome("Alice")
        // TODO: assert that fake.getLastMessage() contains "Alice"
        fail("implement this test");
    }

    @Test
    void sendWelcome_includesWelcome() {
        // TODO: call service.sendWelcome("Bob")
        // TODO: assert that fake.getLastMessage() contains "Welcome"
        fail("implement this test");
    }
}
