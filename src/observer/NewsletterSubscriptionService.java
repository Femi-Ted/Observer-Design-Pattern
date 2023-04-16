package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Subject - the source of the service that Observers/subscribers
 * depend on.
 *
 * This class manages Observers and notifies the Subscribers (Observers) when a new
 * Newsletter is available.
 */
public class NewsletterSubscriptionService implements Subject {
  public List<Observer> observers3Months = new ArrayList<>();
  public List<Observer> observers6Months = new ArrayList<>();
  public List<Observer> observers12Months = new ArrayList<>();
  private String newNewsletter;


  @Override
  public void setNewsletter(String newsletter) {
    this.newNewsletter = newsletter;
    notifyObservers();
  }

  @Override
  public void registerObserver(Observer newObserver) {
    registerObserver(newObserver, "3 months");
  }

  @Override
  public void registerObserver(Observer newObserver, String subscriptionDuration) {
    switch (subscriptionDuration) {
      case "3 months":
        this.observers3Months.add(newObserver);
        break;
      case "6 months":
        this.observers6Months.add(newObserver);
        break;
      case "12 months":
        this.observers12Months.add(newObserver);
        break;
      default:
        throw new IllegalArgumentException("Invalid subscription duration: "
            + subscriptionDuration);
    }
  }

  @Override
  public void removeObserver(Observer newObserver) {
    this.observers3Months.remove(newObserver);
    this.observers6Months.remove(newObserver);
    this.observers12Months.remove(newObserver);
  }

  @Override
  public void notifyObservers() {
    notifyObservers(this.observers3Months);
    notifyObservers(this.observers6Months);
    notifyObservers(this.observers12Months);
  }

  /**
   * Manages a List of Observers to be notified.
   *
   * @param observers the list of Observers subscribed to the service.
   */
  private void notifyObservers(List<Observer> newObservers) {
    for (Observer observer : newObservers) {
      observer.update(this.newNewsletter);
    }
  }
}