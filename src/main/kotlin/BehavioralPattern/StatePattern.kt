package BehavioralPattern

// Context class
class Context {
    private var state: State = StateA()

    fun setState(newState: State) {
        state = newState
    }

    fun request() {
        state.handle(this)
    }
}

// State interface
interface State {
    fun handle(context: Context)
}

// Concrete States
class StateA : State {
    override fun handle(context: Context) {
        println("Handling request in State A")
        // State-specific behavior for State A
        context.setState(StateB())
    }
}

class StateB : State {
    override fun handle(context: Context) {
        println("Handling request in State B")
        // State-specific behavior for State B
        context.setState(StateA())
    }
}

fun main() {
    val context = Context()

    // Initial state is StateA
    context.request()

    // State transition from StateA to StateB
    context.request()

    // State transition from StateB to StateA
    context.request()
}

/*
Out put:
Handling request in State A
Handling request in State B
Handling request in State A

In this example:

Context is the class that contains the internal state and delegates the state-specific behavior to the current state.
State is an interface that defines a method handle which represents the state-specific behavior.
StateA and StateB are concrete implementations of the State interface, each providing its own implementation of the handle method.
In the main function, the Context starts in StateA, and with each call to request, it transitions between StateA and StateB, demonstrating how the behavior of the context changes based on its internal state.

This pattern is useful in scenarios where an object's behavior depends on its internal state, and the state-specific behavior needs to be encapsulated in a clean and modular way. It promotes the separation of concerns and simplifies the code by keeping the behavior associated with each state in a separate class.
 */