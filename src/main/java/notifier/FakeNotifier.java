package notifier;

/**
 * A test double that records whether send() was called.
 * Used for testing NotificationService without real notifications.
 */
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
