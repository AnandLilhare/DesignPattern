package StructurePattern

// Component interface
interface Coffee {
    fun cost(): Double
    fun description(): String
}

// Concrete component
class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 2.0
    }

    override fun description(): String {
        return "Simple Coffee"
    }
}

abstract class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun cost(): Double {
        return coffee.cost()
    }

    override fun description(): String {
        return coffee.description()
    }
}

// Concrete decorators
class MilkDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double {
        // Additional cost for milk
        return super.cost() + 1.0
    }

    override fun description(): String {
        // Additional description for milk
        return super.description() + ", Milk"
    }
}

class SugarDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double {
        // Additional cost for sugar
        return super.cost() + 0.5
    }

    override fun description(): String {
        // Additional description for sugar
        return super.description() + ", Sugar"
    }
}

fun main() {
    // Creating a simple coffee
    var coffee: Coffee = SimpleCoffee()
    var coffee1: Coffee = SimpleCoffee()
    println("Cost: ${coffee.cost()}, Description: ${coffee.description()}")

    // Adding milk to the coffee using a decorator
    coffee = MilkDecorator(coffee)
    println("Cost: ${coffee.cost()}, Description: ${coffee.description()}")

    // Adding sugar to the coffee using a decorator
    coffee = SugarDecorator(coffee)
    println("Cost: ${coffee.cost()}, Description: ${coffee.description()}")
    println("Coffee1 cost: ${coffee1.cost()}, Description: ${coffee1.description()}")
}