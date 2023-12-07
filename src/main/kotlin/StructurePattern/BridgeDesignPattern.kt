package StructurePattern

// Abstraction
interface Shape {
    fun draw(): String
}

// Implementor interface
interface DrawingAPI {
    fun drawCircle(x: Int, y: Int, radius: Int): String
    // Add other drawing methods as needed
}

// Concrete Implementor 1
class DrawingAPI1 : DrawingAPI {
    override fun drawCircle(x: Int, y: Int, radius: Int): String {
        return "API1: Drawing Circle at ($x, $y) with radius $radius"
    }
}

// Concrete Implementor 2
class DrawingAPI2 : DrawingAPI {
    override fun drawCircle(x: Int, y: Int, radius: Int): String {
        return "API2: Drawing Circle at ($x, $y) with radius $radius"
    }
}

// Refined Abstraction
class Circle(private val x: Int, private val y: Int, private val radius: Int, private val drawingAPI: DrawingAPI) : Shape {
    override fun draw(): String {
        return drawingAPI.drawCircle(x, y, radius)
    }
}

// Client code
fun main() {
    val api1: DrawingAPI = DrawingAPI1()
    val api2: DrawingAPI = DrawingAPI2()

    val circle1: Shape = Circle(1, 2, 3, api1)
    val circle2: Shape = Circle(4, 5, 6, api2)

    println(circle1.draw())
    println(circle2.draw())
}
