package notifier;

/**
 * Service class that sends notifications.
 *
 * This class uses Dependency Injection - it receives a Notifier
 * through the constructor instead of creating one itself.
 * This makes the class testable and flexible.
 */
public class NotificationService {

    private final Notifier notifier;

    public NotificationService() {
        this(new EmailNotifier("default@example.com"));
    }

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    /**
     * Sends a welcome message to the given user.
     * Message format: "Welcome to CS-UY 3913, {userName}!"
     */
    public void sendWelcome(String userName) {
        notifier.send("Welcome to CS-UY 3913, " + userName + "!");
    }
}
