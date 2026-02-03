package notifier;

/**
 * Decorator that logs messages before and after sending.
 *
 * This class wraps another Notifier and adds logging behavior.
 * This is an example of the Decorator Pattern.
 *
 * TODO: Implement this class
 * - Add a private field to store the wrapped Notifier
 * - Add a constructor that takes a Notifier to wrap
 * - Implement send() to:
 *   1. Print: [LOG] Before sending: {message}
 *   2. Call wrapped.send(message)
 *   3. Print: [LOG] After sending: {message}
 */
public class LoggingNotifier implements Notifier {

    // TODO: Add private field for wrapped notifier
    private Notifier wrappedNotifier;

    // TODO: Add constructor that takes a Notifier
    public LoggingNotifier(Notifier notif) {
        this.wrappedNotifier = notif;
    }

    @Override
    public void send(String message) {
        // TODO: Log before, call wrapped.send(), log after
        System.out.println("[LOG] Before sending: " + message);
        wrappedNotifier.send(message);
        System.out.println("[LOG] After sending: " + message);
    }
}
