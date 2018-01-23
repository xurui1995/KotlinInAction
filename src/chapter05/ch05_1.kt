package chapter05

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach{
        println("$prefix $it")
    }
}


fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    response.forEach{
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun salute() = println("Salute!")

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)
    println(people.maxBy {p:Person -> p.age })

    val sum = {x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }

    println(sum(1, 2))

   run { println(42) }

    val names = people.joinToString(separator = " ", transform = {p: Person -> p.name})

    println(names)

    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")

    val responses = listOf("200 OK", "418 I'm a teapot",
            "500 Internal Server Error")
    printProblemCounts(responses)

    run(::salute)

    val createPerson = ::Person
    val p = createPerson("Jump",12)
    println(p)
}