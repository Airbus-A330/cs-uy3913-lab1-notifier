package notifier;

/**
 * Service class that sends notifications.
 *
 * TODO: Implement this class
 * - Add a private field to store the Notifier
 * - Add a constructor that takes a Notifier as a parameter
 * - Implement sendWelcome() to send a message containing "Welcome" and the username
 */
public class NotificationService {

    // TODO: Add private field for notifier
    private Notifier notifier;

    // TODO: Add constructor that takes a Notifier
    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    /**
     * Sends a welcome message to the given user.
     * The message must contain "Welcome" and the user's name.
     */
    public void sendWelcome(String userName) {
        // TODO: Call notifier.send() with a welcome message
        notifier.send("Welcome, " + userName + "!");
    }
}
