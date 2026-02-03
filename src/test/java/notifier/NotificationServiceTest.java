package notifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for NotificationService.
 *
 * DO NOT MODIFY THIS FILE.
 *
 * These tests will pass once you correctly implement:
 * - NotificationService (with a constructor that takes a Notifier)
 * - Your Notifier implementations
 */
class NotificationServiceTest {

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
        assertTrue(fake.wasCalled(), "send() should be called");
    }

    @Test
    void sendWelcome_includesUserName() {
        service.sendWelcome("Alice");
        assertNotNull(fake.getLastMessage(), "Message should not be null");
        assertTrue(fake.getLastMessage().contains("Alice"), "Message should contain the username");
    }

    @Test
    void sendWelcome_includesWelcome() {
        service.sendWelcome("Bob");
        assertNotNull(fake.getLastMessage(), "Message should not be null");
        assertTrue(fake.getLastMessage().contains("Welcome"), "Message should contain 'Welcome'");
    }
}
