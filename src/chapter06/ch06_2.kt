package chapter06

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We are ${percent}% done!")
}

data class Person3(val name: String, val age: Int? = null) {
    fun isOlderThan(other: Person3): Boolean? {
        if (age == null || other.age == null) {
            return null
        }
        return age > other.age
    }
}

fun foo(l: Long) = println(l)

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}
fun main(args: Array<String>) {
    showProgress(146)

    println(Person3("Sam", 35).isOlderThan(Person3("Amy", 42)))
    println(Person3("Sam", 35).isOlderThan(Person3("Jane")))

    val x = 1
    println(x.toLong() in listOf(1L, 2L, 3L))

    val b: Byte = 1
    val l =b + 1L
    foo(42)

    println("42".toInt())

    //fail("Error")

}