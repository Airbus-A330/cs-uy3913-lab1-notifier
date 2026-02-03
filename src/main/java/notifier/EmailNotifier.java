package notifier;

/**
 * Sends notifications via email.
 */
public class EmailNotifier implements Notifier {

    private final String recipientEmail;

    public EmailNotifier(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    @Override
    public void send(String message) {
        System.out.println("[EMAIL] Sending to " + recipientEmail + ": " + message);
    }
}
