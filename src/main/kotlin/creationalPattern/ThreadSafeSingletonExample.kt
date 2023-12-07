package creationalPattern

class ThreadSafeSingletonExample private constructor(){

    companion object {
        @Volatile
        private var instance:ThreadSafeSingletonExample? = null

        fun getInstance() : ThreadSafeSingletonExample {
            return instance ?: synchronized(this) {
                return instance?:ThreadSafeSingletonExample().also { instance = it }
            }
        }

    }

    init {
        println("ThreadSafeSingleton instance created")
    }

    fun doSomething() {
        println("ThreadSafeSingleton is doing something")
    }
}

fun main() {
    val singletonExample1 = ThreadSafeSingletonExample.getInstance()
    val singletonExample2 = ThreadSafeSingletonExample.getInstance()

    singletonExample1.doSomething()
    singletonExample2.doSomething()
}