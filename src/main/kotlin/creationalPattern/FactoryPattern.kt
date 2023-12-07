package creationalPattern

interface Shape {
    fun draw()
}

class Rectangle: Shape{
    override fun draw() {
        println("Drawing the Rectangle")
    }
}

class Circle: Shape{
    override fun draw() {
        println("Drawing the Circle")
    }
}

class Square: Shape{
    override fun draw() {
        println("Drawing the Square")
    }
}

fun main() {
    val rectangle:Shape = Rectangle()
    val circle:Shape = Circle()
    val square:Shape = Square()
    rectangle.draw()
    circle.draw()
    square.draw()
}