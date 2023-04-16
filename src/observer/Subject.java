package observer;

/**
 * This interface defines the actions that the Subject (Source) enforces on its subscribers
 * (the Observers/Receivers).
 */
public interface Subject {

  /**
   * Sets the newsletter to be sent to observers.
   * @param newsletter the newsletter to be sent to observers.
   */
  void setNewsletter(String newsletter);

  /**
   * Registers the Observer (subscriber) to the service so that they can receive newsletters when
   * new issues are released or changes occur at the Subject.
   *
   * @param newObserver the observer/subscriber to the service.
   */
  void registerObserver(Observer newObserver);

  /**
   * Method overloading to manage Observers's with a subscription plan.
   *
   * @param newObserver the Observer to be registered with a subscription plan.
   * @param subscriptionDuration the subscription duration the Observer is registered to.
   */
  void registerObserver(Observer newObserver, String subscriptionDuration);

  /**
   * Removes the observer/subscriber from list of recipient to
   * receive update on new issue of newsletters.
   *
   * @param newObserver the observer to be removed.
   */
  void removeObserver(Observer newObserver);

  /**
   * Notifies the observer when new issue/edition of newsletter is available for dissemination.
   */
  void notifyObservers();
}
