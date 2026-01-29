package notifier;

/**
 * Service class that sends notifications.
 *
 * This class uses Dependency Injection - it receives a Notifier
 * through the constructor instead of creating one itself.
 * This makes the class testable and flexible.
 *
 * TODO: Implement this class
 * - Add a private field to store the Notifier
 * - Add a constructor that takes a Notifier as a parameter
 * - Implement sendWelcome() to send: "Welcome to CS-UY 3913, {userName}!"
 */
public class NotificationService {

    // TODO: Add private field for notifier

    // TODO: Add constructor that takes a Notifier

    /**
     * Sends a welcome message to the given user.
     * Message format: "Welcome to CS-UY 3913, {userName}!"
     */
    public void sendWelcome(String userName) {
        // TODO: Call notifier.send() with welcome message
    }
}
