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

    // TODO: Add constructor that takes Notifier and maxRetries

    @Override
    public void send(String message) {
        // TODO: Implement retry logic
    }
}
