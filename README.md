# Observer-Design-Pattern: 

## A Design Pattern Presentation.


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




CODE EXAMPLE of the Implementation of the Observer Design Pattern:


UML Diagram of Code Example:<br>
![Screenshot 2023-04-16 at 00 00 25](https://user-images.githubusercontent.com/46625599/232278829-db8d281c-0bcf-41e1-8c51-1078c39459a8.png)<br>
		_Figure 2: UML diagram of the Observer Design Pattern example provided._




