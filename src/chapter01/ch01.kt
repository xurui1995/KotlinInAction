package chapter01

/**
 * Created by xur on 2018/1/16.
 */
data class Person(val name: String,
                  val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"),
                         Person("Bob", age = 19))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("the oldest is: $oldest")
}