package chapter04

import java.io.File

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

fun main(args: Array<String>) {
    println(CaseInsensitiveFileComparator.compare(
            File("/User"), File("/user")))
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))

    A.bar()
    A.Test.test()

    val subscribingUser = User3.newSubscribingUser("jump@myheaert.com")
    println(subscribingUser.nickname)
}

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            return p1.name.compareTo(p2.name)
        }

    }
}

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }

    object Test {
        fun test() {
            println("test")
        }
    }
}

class User3 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = User3(email.substringBefore('@'))
    }
}