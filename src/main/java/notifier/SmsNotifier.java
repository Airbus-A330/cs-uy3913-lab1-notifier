package notifier;

/**
 * Sends notifications via SMS.
 *
 * TODO: Implement this class
 * - Add a private field to store the phone number
 * - Add a constructor that takes the phone number as a parameter
 * - Implement send() to print: [SMS] Sending to {phone}: {message}
 */
public class SmsNotifier implements Notifier {

    // TODO: Add private field for phone number
    private final String phoneNumber;

    // TODO: Add constructor that takes phone number
    public SmsNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        // TODO: Print message in format: [SMS] Sending to {phone}: {message}
        System.out.println("[SMS] Sending to " + phoneNumber + ": " + message);
    }
}
