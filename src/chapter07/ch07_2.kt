package chapter07

class Point2(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean = when(other) {
        this -> true
        !is Point -> false
        else -> other.x == x && other.y == y
    }
}

class Person(val firstName: String, val lastName: String): Comparable<Person>{
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }

}
fun main(args: Array<String>) {
    println(Point(10, 20) == Point(10, 20))
    println(Point(10, 20) != Point(5, 5))
    println(null == Point(1, 2))

    val p1 = Person("Alice", "Smith")
    val p2 = Person("Alice", "Zoo")
    println(p1 < p2)

    println("abc" < "bac")
}