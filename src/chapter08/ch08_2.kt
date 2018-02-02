package chapter08

import java.io.BufferedReader
import java.io.FileReader

data class Person2(val name: String, val age: Int)
val people =
        listOf(Person2("Alice", 29), Person2("Bob", 31))

fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br -> return br.readLine() }
}
fun main(args: Array<String>) {
    println(people.filter { it.age < 30 }.map {it.name})
}
