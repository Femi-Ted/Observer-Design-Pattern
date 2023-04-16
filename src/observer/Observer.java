package observer;

/**
 * This interface defines the behaviour which Observers/Subscribers use to receive updates on
 * changes at the Subject - when the state of the newsletters managed by the Subject changes.
 */
public interface Observer {

  /**
   * Updates the observer/subscriber when new content/Newsletter is available.
   * @param newsletter the notification to show that observer has been notified.
   */
  void update(String newsletter);
}
