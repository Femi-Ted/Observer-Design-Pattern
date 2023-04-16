package observer;

/**
 * This class represents a subscriber/Observer that will receive updates from the Newsletter
 * Subscription Service - the Concrete Subject.
 *
 */
public class NewsletterSubscriber implements Observer {
  private String newsletter;
  private String subscriptionDuration;

  /**
   * Constructs an Observer object and instantiates it with the specified parameters.
   *
   * @param newsletter the newsletter to be disseminated.
   * @param subscriptionDuration the Observer/Subscriber's subscription duration.
   */
  public NewsletterSubscriber(String newsletter, String subscriptionDuration) {
    this.newsletter = newsletter;
    this.subscriptionDuration = subscriptionDuration;
  }

  @Override
  public void update(String message) {
    System.out.println("New Newsletter received: "
        + message
        + " sent to "
        + this.newsletter
        + " (Subscription duration: "
        + this.subscriptionDuration + ")");
  }
}