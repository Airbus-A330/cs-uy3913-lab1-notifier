package notifier;

/**
 * Decorator that retries sending if it fails.
 *
 * This class wraps another Notifier and adds retry logic.
 * If send() throws an exception, it will retry up to maxRetries times.
 *
 * TODO: Implement this class
 * - Add private fields for the wrapped Notifier and maxRetries (int)
 * - Add a constructor that takes a Notifier and maxRetries
 * - Implement send() to:
 *   1. Try calling wrapped.send(message)
 *   2. If it throws an exception, retry up to maxRetries times
 *   3. Print attempt info: [RETRY] Attempt {n} of {maxRetries}
 *   4. If all retries fail, throw RuntimeException
 */
public class RetryingNotifier implements Notifier {

    // TODO: Add private fields for wrapped notifier and maxRetries
    private Notifier wrappedNotifier;
    private int maxRetries;

    // TODO: Add constructor that takes Notifier and maxRetries
    public RetryingNotifier(Notifier notif, int maxRetries) {
        this.wrappedNotifier = notif;
        this.maxRetries = maxRetries;
    }

    @Override
    public void send(String message) {
        // TODO: Implement retry logic

        // Log how many attempts have been made; start at 0.
        int attempts = 0;

        // We're going to keep trying this until we either succeed or run out of attempts.
        while (true) {  
            try {
                // Try to send the message using the wrapped notifier.
                wrappedNotifier.send(message);

                // It worked, exit the loop.
                return;
            } catch (Exception e) {
                // It didn't work, so increment the attempt counter.
                attempt++;

                // If we've exceeded maxRetries, throw a RuntimeException.
                if (attempt > maxRetries) {
                    // Throw a custom RuntimeException error
                    throw new RuntimeException("Failed to send message after the maximum amount of retries.", e);
                }

                System.out.println("[RETRY] Attempt " + attempts + " of " + maxRetries);
            }
        }
    }
}
