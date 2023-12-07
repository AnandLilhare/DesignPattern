package StructurePattern


// Existing class (Adaptee)
class OldSystem {
    fun request(): String {
        return "Response from Old System"
    }
}

// Target interface (expected by the client)
interface NewSystem {
    fun newRequest(): String
}

// Adapter class implementing the NewSystem interface
class OldSystemAdapter(private val oldSystem: OldSystem) : NewSystem {
    override fun newRequest(): String {
        // Adapting the old request() method to newRequest()
        return oldSystem.request()
    }
}

fun main() {
    // Using the NewSystem interface with the OldSystemAdapter
    val oldSystem = OldSystem()
    val adapter: NewSystem = OldSystemAdapter(oldSystem)

    // The client code interacts with the NewSystem interface
    println(adapter.newRequest())
}

