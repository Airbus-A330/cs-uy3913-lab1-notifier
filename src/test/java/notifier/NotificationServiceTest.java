package notifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for NotificationService.
 *
 * DO NOT MODIFY THIS FILE.
 *
 * These tests verify that your NotificationService implementation:
 * - Calls the notifier's send() method
 * - Includes the user's name in the message
 * - Includes "Welcome" in the message
 */
class NotificationServiceTest {

    private static class FakeNotifier implements Notifier {
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

    private FakeNotifier fake;
    private NotificationService service;

    @BeforeEach
    void setUp() {
        fake = new FakeNotifier();
        service = new NotificationService(fake);
    }

    @Test
    void sendWelcome_callsSend() {
        service.sendWelcome("Test");
        assertTrue(fake.wasCalled());
    }

    @Test
    void sendWelcome_includesUserName() {
        service.sendWelcome("Alice");
        assertNotNull(fake.getLastMessage());
        assertTrue(fake.getLastMessage().contains("Alice"));
    }

    @Test
    void sendWelcome_includesWelcome() {
        service.sendWelcome("Bob");
        assertNotNull(fake.getLastMessage());
        assertTrue(fake.getLastMessage().contains("Welcome"));
    }
}
