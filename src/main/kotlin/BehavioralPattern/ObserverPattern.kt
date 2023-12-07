package BehavioralPattern

// Observer interface
interface Observer {
    fun update(message: String)
}

// Concrete Observer
class ConcreteObserver(private val name: String) : Observer {
    override fun update(message: String) {
        println("$name received message: $message")
    }
}

// Subject interface
interface Subject {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers(message: String)
}

// Concrete Subject
class ConcreteSubject : Subject {
    private val observers = mutableListOf<Observer>()

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers(message: String) {
        for (observer in observers) {
            observer.update(message)
        }
    }

    // Example method that changes the state of the subject and notifies observers
    fun performAction() {
        val message = "Subject performed an action"
        println("Subject: $message")
        notifyObservers(message)
    }
}

fun main() {
    // Create observers
    val observer1 = ConcreteObserver("Observer 1")
    val observer2 = ConcreteObserver("Observer 2")

    // Create subject
    val subject = ConcreteSubject()

    // Add observers to the subject
    subject.addObserver(observer1)
    subject.addObserver(observer2)

    // Perform an action that notifies observers
    subject.performAction()

    // Remove an observer
    subject.removeObserver(observer1)

    // Perform another action
    subject.performAction()
}
