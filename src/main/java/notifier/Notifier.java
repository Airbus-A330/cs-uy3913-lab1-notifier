package notifier;

/**
 * Interface for sending notifications.
 * All notifier classes must implement this interface.
 */
public interface Notifier {
    void send(String message);
}
