package chapter02

/**
 * Created by xur on 2018/1/16.
 */
class Person(val name:String,
             var isMarried: Boolean
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}
fun main(args: Array<String>) {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)

   println( Rectangle(6,6).isSquare)
}