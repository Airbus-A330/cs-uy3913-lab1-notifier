package notifier;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sends the same message to multiple notifiers.
 *
 * This is an example of the Composite Pattern - treating a group
 * of objects the same as a single object.
 *
 * TODO: Implement this class
 * - Add a private List<Notifier> field to store notifiers
 * - Add a constructor that takes Notifier... (varargs)
 * - Implement send() to call send(message) on each notifier in the list
 */
public class CompositeNotifier implements Notifier {

    // TODO: Add private List<Notifier> field

    // TODO: Add constructor that takes Notifier... (varargs)
    // Hint: Use Arrays.asList() to convert varargs to List

    @Override
    public void send(String message) {
        // TODO: Loop through notifiers and call send() on each
    }
}
