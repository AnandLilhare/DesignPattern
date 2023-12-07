package creationalPattern

interface IShape {
    fun draw()
}
// Concrete implementations of Shape
class RectangleClass : IShape {
    override fun draw() {
        println("Drawing Rectangle")
    }
}

class CircleClass : IShape {
    override fun draw() {
        println("Drawing Circle")
    }
}

class SquareClass : IShape {
    override fun draw() {
        println("Drawing Square")
    }
}

// ShapeFactory interface
interface ShapeFactory {
    fun createShape(): IShape
}

// Concrete implementations of ShapeFactory

class RectangleFactory : ShapeFactory {
    override fun createShape(): IShape {
        return RectangleClass()
    }
}

class CircleFactory : ShapeFactory {
    override fun createShape(): IShape {
        return CircleClass()
    }
}
class SquareFactory : ShapeFactory {
    override fun createShape(): IShape {
        return SquareClass()
    }
}

fun main() {
    val circleFactory: ShapeFactory = CircleFactory()
    val rectangleFactory: ShapeFactory = RectangleFactory()
    val squareFactory: ShapeFactory = SquareFactory()

    val circle: IShape = circleFactory.createShape()
    val rectangle: IShape = rectangleFactory.createShape()
    val square: IShape = squareFactory.createShape()

    circle.draw()
    rectangle.draw()
    square.draw()
}


