package chapter05

data class Person2(val name: String, val age: Int)

class Book(val title: String, val authors: List<String>)

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })

    val people = listOf(Person2("Jump", 12), Person2("Holy",13))
    println(people.filter { it.age > 12 })

    println(list.map { it * it })

    println(people.map { it.name })

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    println(people.all { it.age < 20 })

    println(!list.all { it == 3 })

    println(list.any {it != 3})

    println(people.find { it.age < 20 })

    println(people.groupBy { it.age })

    val list2 = listOf("a", "b", "ab")
    println(list2.groupBy (String::first))

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
            Book("Mort", listOf("Terry Pratchett")),
            Book("Good Omens", listOf("Terry Pratchett",
                    "Neil Gaiman")))
    println(books.flatMap { it.authors }.toSet())
}