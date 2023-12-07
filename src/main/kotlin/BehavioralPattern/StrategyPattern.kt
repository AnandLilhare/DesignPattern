package BehavioralPattern

// Strategy interface
interface PaymentStrategy {
    fun pay(amount: Double)
}

// Concrete Strategies
class CreditCardPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using Credit Card")
    }
}

class PayPalPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using PayPal")
    }
}

class BankTransferPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using Bank Transfer")
    }
}

// Context
class ShoppingCart(private val paymentStrategy: PaymentStrategy) {
    fun checkout(amount: Double) {
        paymentStrategy.pay(amount)
    }
}

fun main() {
    // Client code
    val creditCardPayment = CreditCardPayment()
    val payPalPayment = PayPalPayment()
    val bankTransferPayment = BankTransferPayment()

    val shoppingCart1 = ShoppingCart(creditCardPayment)
    val shoppingCart2 = ShoppingCart(payPalPayment)
    val shoppingCart3 = ShoppingCart(bankTransferPayment)

    shoppingCart1.checkout(100.0)
    shoppingCart2.checkout(150.0)
    shoppingCart3.checkout(200.0)
}


//In this example:
//
//The PaymentStrategy interface declares a method pay that concrete strategies must implement.
//Concrete strategies (CreditCardPayment, PayPalPayment, and BankTransferPayment) provide specific implementations of the payment method.
//The ShoppingCart class represents the context that uses a payment strategy. The checkout method in ShoppingCart delegates the payment to the selected strategy.
//In the main function, different payment strategies are created, and shopping carts use them to perform checkouts with varying amounts.
//This way, the client code (e.g., the main function) can easily switch between different payment strategies without modifying the ShoppingCart class. The Strategy Pattern promotes flexibility and extensibility, allowing new payment strategies to be added without affecting existing code.