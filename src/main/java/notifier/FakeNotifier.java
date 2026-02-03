package notifier;

/**
 * A test double that records whether send() was called.
 * Used for testing NotificationService without real notifications.
 *
 * TODO: Implement this class
 * - Add a private boolean field to track if send() was called
 * - Add a private String field to store the last message
 * - Implement send() to record that it was called and store the message
 * - Implement wasCalled() to return whether send() was ever called
 * - Implement getLastMessage() to return the stored message
 */
public class FakeNotifier implements Notifier {

    // TODO: Add private boolean field to track if send() was called
    private boolean sendCalled = false;

    // TODO: Add private String field to store the last message
    private String lastMessage = "";

    @Override
    public void send(String message) {
        // TODO: Record that send was called and store the message
        sendCalled = true;
        lastMessage = message;
    }

    public boolean wasCalled() {
        // TODO: Return true if send() was called
        return sendCalled;
    }

    public String getLastMessage() {
        // TODO: Return the last message that was sent
        return lastMessage;
    }
}
