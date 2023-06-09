# Observer-Design-Pattern: 

## A Design Pattern Presentation Requirement for CS5004 (Spring 2023).


### **Introduction:**
Of the twenty-three design patterns focused on in the “Design Patterns: Elements of Reusable Object-Oriented Software” textbook by the “Gang of Four” (Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides), the Observer Design Pattern belongs to the Behavioural Design Patterns class, a classification of design patterns that are largely concerned with maintaining communication between objects, and how they interact and distribute responsibilities between objects [1].


### **The Observer Design Pattern and communication inside the program:**
This pattern defines a one-to-many relationship between objects where when one object changes state and needs to notify other objects dependent on its functionality/service, it does so automatically through a subscription-like service.  In this pattern, the object that keeps a list of dependents to update with information when its state changes is called the Subject, while the dependents that relies on this updates are called Observers. 


### **Observer Design Pattern and Loose Coupling:**
This design pattern supports loose coupling between objects, making it easy to add new Observers without affecting the Subject or other Observers.  



### **The key participants in the Observer Design Pattern:**
1.	**The Subject:** the Subject keeps a detailed list of its dependents (the Observers/Subscribers) and notifies them of any changes to its state.  This is implemented as an interface so that any Concrete implementation represents the Object whose state would be required to change.  There are three important behaviour that all concrete implementations must provide:<br>
&nbsp; &nbsp; &nbsp; &nbsp;* register Observer: provide a means to enlist Observers to be notified when a change of state of the Subject occurs. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* remove Observer: provide a means to delist Observer so Observers no longer receive notice of state changes in the Subject. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* notify Observer: provide an implementation to notify Observers when a state change occurs in the Subject. <br>

2.	**The Observer:** represents the dependents that would be receiving updates from the Subject.  This is implemented as an interface so that any concrete implementation represents an Observer object.  Only one method is implemented: <br>
&nbsp; &nbsp; &nbsp; &nbsp;* update: which defines how the Observer calls at the Subject to check if new information is available. <br>

Note: Implementation could vary depending on whether the Subject is to push updates to the Observers or if Observers would be fetching updates from the Subject.

3.	**The Concrete Subject:** this is the concrete implementation of the Subject (the NewsletterSubscriptionService.java Class in my example) and is the object that sends notifications to the list of observers it manages when its state changes.<br>
4.	**The Concrete Observer:** this is the concrete implementation of the Observer (the NewsletterSubscriber.java class in my example) that represents subscriber objects that will receive updates from the Subject and takes appropriate actions.

 
Check out figure 1 which details the relationship between the Subject and the Observer. <br>

 ![image](https://user-images.githubusercontent.com/46625599/232278722-1578b9b0-3fe8-4037-ac97-fc489dfe81af.png)
		_Figure 1: Attributes showing the relationship between the Subject and Observer:_


### **Where the Observer Design Pattern in used in design:**
The Observer Design Pattern provides a flexible way to send notifications to multiple objects at once and by this, reduces duplicate code and separates the notification code from the business or service logic of the entire application.  The Observer Design Pattern can be found:<br>
&nbsp; &nbsp; &nbsp; &nbsp;* useful in events handling in GUI implementations in the MVC Design Pattern. Specifically, it is found operational in the java.util.EventListener, in the EventListner Interface for Swing, where button clicks activates listeners to perform certain actions dependent on the update received from the Model [6].<br>
&nbsp; &nbsp; &nbsp; &nbsp;* for creating dynamic and responsive user interfaces that communicates to users when program state changes.<br>
&nbsp; &nbsp; &nbsp; &nbsp;* and various program notification systems.<br>



### **How to know when to use the Observer Design Pattern:**
Once you see that a one-to-many relationship exist between objects in code, and many of those objects depend on changes in the state of at least one particular object in the entire program implementation, then it is time to decouple the objects from each other using the Observer Design Pattern.  In details, the checks to implement to see if it is time to upgrade our code to use the Observer Design Pattern includes:
1.	When you see that one or multiple objects need to be updated about the changes in state of another object, then it is time to upgrade our code to implement Observer Design Pattern between the objects.
2.	When you see that there is code duplication in maintaining information exchange between one object and many others.
3.	When you need to introduce new functions to the code of objects that were previously communicating, without breaking the original code.
4.	When it is necessary to copy a publish/subscribe relationship amongst code objects. 



### **The Observer Design Pattern and the SOLID Principles:**
The Observer Design Pattern adheres to the Solid Principles in many ways which are explained below:
1.	**Single Responsibility Principle:** the Observer Design Patter separates the responsibility of the source of the update from that of the destination, that is, there is clear division of labour between the Subject and the Observer.  As I have explained above, the Subject is responsible for maintaining the state and notifying the Observer of any changes, while the Observer is responsible for receiving and handling the updates.  These roles are never interchanged.
2.	**Open-Closed Principle:** By the Concrete Subject implementing to the interface of the Subject and the Concrete Observer implementing to the Interface of the Observer, the design pattern allows the addition of new Observers and even Subjects without modifying the exiting code.  The Subject only needs to know about the Observer interface, and any new Observer only needs to implement the Observer interface to be added to the list being maintained by the Subject.   This means that the Observer Design Pattern is open for extension but closed for modifications.
3.	**Liskov Substitution Principle:** since the Observer Design Pattern allows for different types of Observers to be used interchangeably through Polymorphism, any class that implements the Observer interface becomes an Observer as well, and an immediate candidate for enlistment by the Subject who does not care about the new Observer’s specific implementation details. Since these Super-type sub-type dynamics is not affected when more observers are created, then we can say that the Observer Design Pattern adheres to the Liskov Substitution Principle.
4.	**Interface Segregation Principle:** since only a minimal focused interface is needed by the Observer, with only a single method required for receiving updates, it ensures that the Observer interface is not bloated with unnecessary methods, and each Observer only needs to implement what it requires.  This endows Concreted Observers and Subjects with the power of modularity where classes being created can be easily modified or replaced without causing any disruption to the rest of the communication system.  Finally, we can argue that since the Interfaces involved in the Observer Design Pattern are minimal and highly supportive of loose coupling between Objects, then the requirements of the Interface Segregation Principle has been met.
5.	**Dependency Inversion Principle:** this principle promotes loose coupling between components and supports implementations where high-level modules or classes should not depend on low-level components.  In the Observer Design Pattern, abstraction is used to decouple the Subject and Observer, with the Subject depending on an abstract Observer Interface rather than any of the Concrete Observer implementation which allows for more flexibility and easier maintenance, as changes to the Observer Implementation do not affect the Subject.


### **Advantages of Using the Observer Design Pattern:**
1.	Since the design pattern promotes loose coupling between objects, implementing to Composition rather than inheritance, it makes for a better design choice when it is important that Objects interact without needing to know the details of each other’s implementation.
2.	The design pattern is flexible and easily extensible because it allows addition of new Observers without having to go into the code of the Subject or even other Observers.  
3.	It encourages efficiency in the dissemination of information/updates within software systems since information is shared only when they are available.
4.	It encourages easier code maintenance and feature updates in the Subject and Observer since each of their roles are clearly defined.



### **Limitations of Using the Observer Design Pattern:**
1.	The pattern can lead to a more complex code structure when there are many Observers to be maintained and many different notifications to be updated to different Observers.
2.	Overall code performance issues would result when if the system is overloaded with unnecessary and frequent broadcast of updates to Observers.  The more Observers being maintained, the likelihood of inefficiencies creeping in.
3.	It could cause severe memory leaks if Observers are not properly expunged from the list maintained by the Subject.  This memory leaks could be fatal to operation in large systems.




## CODE EXAMPLE of the Implementation of the Observer Design Pattern:


**UML Diagram of Code Example**:<br>
![Screenshot 2023-04-16 at 00 00 25](https://user-images.githubusercontent.com/46625599/232278829-db8d281c-0bcf-41e1-8c51-1078c39459a8.png)<br>
		_Figure 2: UML diagram of the Observer Design Pattern example provided._



<br>
## My code implementation can be explained thus: <br>
1.	**the Observer Interface (Observer.java)**: has a single method “update”, that takes a “String” parameter representing the new newsletter that is available.  The Interface defines the behaviour that Observers/Subscribers use to receive updates when changes occur at the Subject.  The Subject is responsible for maintaining a list of observers, and when it’s state changes, it notifies all of its enlisted observers by calling the “update” method on each of them.  The “newsletter” parameter is a notification message that shows that the Observer has been notified of the new content.<br>

```java
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
```

<br>
2.	**the Subject Interface (Subject.java)**: this defines the actions that the Subject enforces on its subscribers/Observers.  There are four methods:<br>
&nbsp; &nbsp; &nbsp; &nbsp;* “setNewsletter” method: used to set the newsletter to be sent to the Observers. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* “registerObserver” method: used to register an Observer with the service so that they can receive newsletters when new issues are released or changes occur at the Subject. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* “removeObserver” method: used to remove the Observer from the list of recipients who receive updates on new issues of newsletters. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* “notifyObservers” method: used to notifiy the Observers when a new issue/edition of the newsletter is available for dissemination.<br>

```java
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
```

<br>
3.	**The Concrete Implementation of the Observer Interface – (NewsletterSubscriber.java)**: which represents an “Observer object” that would receive updates from a “Subject” object (NewsletterSubscriptionService.java class) when its state changes.  My concrete implementation of the Observer Interface has two instance variables “newsletter” and “subscriptionDuration”, which holds the names of the newsletter to be disseminated and the subscriber’s subscription duration, respectively. It also has a constructor that takes in these two parameters and initializes the instance variables. <br>

The class implements the “update” method of the Observer Interface.  It is this method the Subject calls when it has new information to disseminate to its Observers.  When a new Newsletter has been received, the update method prints a message indicating that along with the name of the newsletter, the subscription duration of the observer, and the message that was sent. <br>

```java
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
```

<br>
4. 	**The Concrete Implementation of the Subject Interface – (NewsletterSubscriptionService.java)**:  represents the “Subject object” and the service provider to which the Observers/Subscribers depend on to receive notifications when new newsletters become available.  It implements the following methods:<br>

&nbsp; &nbsp; &nbsp; &nbsp;* **data structure instance attributes**: Subject uses this to keep the list of Observers. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* **setNewsletter(String newsletter)**: This method sets the newsletter that will be disseminated to the observers and calls the notifyObservers() method to inform all registered observers. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* **registerObserver(Observer newObserver)**: This method registers the observer to the Newsletter Subscription Service with a default subscription duration of three months. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* **registerObserver(Observer newObserver, String subscriptionDuration)**: This is an overloaded method that allows an observer to be registered with a specified subscription duration (3 months, 6 months or 12 months). <br>
&nbsp; &nbsp; &nbsp; &nbsp;* **removeObserver(Observer newObserver)**: This method removes the observer from the list of recipients that will receive the newsletter updates. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* **notifyObservers()**: This method calls the notifyObservers(List<Observer> newObservers) method with three different observer lists - one for each subscription duration period - to ensure all registered observers are notified of the new newsletter. <br>
&nbsp; &nbsp; &nbsp; &nbsp;* **notifyObservers(List<Observer> newObservers)**: This method notifies all registered observers by iterating through the list of observers and calling their update() method, passing in the new newsletter as a parameter. <br>

```java
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
```


<br>	
5. 	**The driver class (Main)**: my implementation for the Observer Design Pattern comes together here to simulate a newsletter subscription service that sends newsletters to subscribers. The operations implemented is as follows: <br>

&nbsp; &nbsp; &nbsp; &nbsp;* In the main method, it first creates an instance of NewsletterSubscriptionService, which acts as the Subject, and then creates three instances of NewsletterSubscriber, which act as the Observers/subscribers. <br>

&nbsp; &nbsp; &nbsp; &nbsp;* Each of the subscribers has a different subscription duration (3, 6, or 12 months), and they are registered with the subscription service using the registerObserver method. <br>

&nbsp; &nbsp; &nbsp; &nbsp;* Then, the service sends out two newsletters, and each subscriber receives them because they were registered. The newsletters are sent using the setNewsletter method of the service, which triggers the notifyObservers method, which sends the message to all registered observers. <br>

&nbsp; &nbsp; &nbsp; &nbsp;* Finally, the second subscriber is removed from the list of subscribers using the removeObserver method, and the service sends another newsletter. This time, only the remaining subscribers receive the newsletter because the second subscriber was removed. <br>

```java
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
```


## Conclusion:
The Observer Design Pattern is a useful software design pattern that allows for efficient communication between objects in a system. This pattern promotes loose coupling between objects and provides a way for objects to receive updates and notifications without being tightly coupled to the source of the updates. This makes it easier to add new objects to the system and modify the behavior of existing objects without causing significant impact to the system as a whole. The Observer Design Pattern is widely used in many software systems, and it is a pattern that every software developer should be familiar with.


===========================================================<br>
You can check out the code implementation in the src folder.






## References:

[1] E. Gamma, R. Helm, R. Johnson, and J. Vlissides, "Observer," in Design Patterns: Elements of Reusable Object-Oriented Software, Reading, MA: Addison-Wesley Professional, 1994, pp. 293-304. <br>
[2] Refactoring Guru, “Observer”. [Online]. Available: https://refactoring.guru/design-patterns/observer. [Accessed April-14-2023].
