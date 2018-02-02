package chapter08

data class Person3(val name: String, val age: Int)

fun lookForAlice(people: List<Person3>) {
    println("lookForAlice")
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
        println("${person.name} is not Alice")
    }
    println("Alice is not found")
}

fun lookForAlice2(people: List<Person3>) {
    println("lookForAlice2")
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
        println("${it.name} is not Alice")
    }
    println("Alice is not found")
}

fun lookForAlice3(people: List<Person3>) {
    println("lookForAlice3")
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found!")
            return@label
        }
        println("${it.name} is not Alice")
    }
    println("Alice might be somewhere")
}


fun lookForAlice4(people: List<Person3>) {
    println("lookForAlice4")
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return@forEach
        }
        println("${it.name} is not Alice")
    }
    println("Alice might be somewhere")
}

fun lookForAlice5(people: List<Person3>) {
    println("lookForAlice5")
    people.forEach(fun (person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}

fun main(args: Array<String>) {
    val people =
            listOf(Person3("Alice", 29), Person3("Bob", 31))

    lookForAlice(people)
    lookForAlice2(people)
    lookForAlice3(people)
    lookForAlice4(people)
    lookForAlice5(people)

    println(StringBuilder().apply sb@{
        listOf(1,2,3).apply {
            this@sb.append(this[1])
        }
    })

}