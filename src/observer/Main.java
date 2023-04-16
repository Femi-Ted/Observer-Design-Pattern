package observer;

/**
 * Main class to demonstrate the operations of the Subject (the NewsletterSubscriptionService class)
 * and Observer (the NewsletterSubscriber class) in the Observer Design Pattern Presentation.
 */
public class Main {

  /**
   * Driver.
   * @param args system default argument at main.
   */
  public static void main(String[] args) {
    // Create Subject.
    NewsletterSubscriptionService newsletterService = new NewsletterSubscriptionService();

    // Create Observer 1 (subscriber 1) into their subscription category.
    NewsletterSubscriber subscriber1 = new NewsletterSubscriber(
        "subscriber1@example.com", "3 months");
    // Register Observer 1 (subscriber 1) to receive updates.
    newsletterService.registerObserver(subscriber1);

    // Create Observer 2 (subscriber 2) into their subscription category.
    NewsletterSubscriber subscriber2 = new NewsletterSubscriber(
        "subscriber2@example.com", "6 months");
    // Registers Observer 2 (subscriber 2) to receive updates.
    newsletterService.registerObserver(subscriber2);

    // Create Observer 3 (subscriber 3) into their subscription category.
    NewsletterSubscriber subscriber3 = new NewsletterSubscriber(
        "subscriber3@example.com", "12 months");
    // Registers Observer 3 (subscriber 3) to receive updates.
    newsletterService.registerObserver(subscriber3);

    // Send first issue of newletter to registered Observers.
    System.out.println("\nFirst Newsletter issue release:");
    newsletterService.setNewsletter("New Newsletter 1");

    // Send second issue of newletter to registered Observers.
    System.out.println("\nSecond Newsletter issue release:");
    newsletterService.setNewsletter("New Newsletter 2");

    // Observer 2 (subscriber 2) removed from receiving updates.
    // Only registered Observers will gets updates.
    System.out.println("\nThird Newsletter issue release but "
        + "Subscriber 2 removed from receiving updates:");
    newsletterService.removeObserver(subscriber2);
    newsletterService.setNewsletter("New Newsletter 3");
  }
}