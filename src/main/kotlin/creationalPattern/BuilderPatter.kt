package creationalPattern

class User private constructor(builder:Builder) {
    val firstName: String?
    val lastName: String?
    val age:Int
    val email:String?

    init {
        this.firstName = builder.firstName
        this.lastName = builder.lastName
        this.age = builder.age
        this.email = builder.email
    }

    override fun toString(): String {
        return "User(fistName=$firstName, lastName=$lastName, age=$age, email=$email"
    }

    class Builder {
       var firstName: String? = null
       var lastName: String? = null
       var age:Int = 0
       var email:String? = null
       fun firstName(firstName:String) = apply { this.firstName = firstName }
       fun lastName(lastName:String)  = apply { this.lastName = lastName }
       fun age(age : Int) = apply { this.age = age }
       fun email(email:String) = apply { this.email = email }

       fun build() : User {
           return User(this)
       }

    }
}

fun main() {
    val user = User.Builder()
        .firstName("Anand")
        .lastName("Lilhare")
        .age(35)
        .email("AnandLilhare69@gmail.com")
        .build()
    println(user)
}