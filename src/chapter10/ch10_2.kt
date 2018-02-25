package chapter10

import kotlin.reflect.KFunction
import kotlin.reflect.full.memberProperties

class Person(val name: String, val age: Int)

fun foo(x: Int) = println(x)

var counter = 0

fun main(args: Array<String>) {
    val person = Person("Alice", 20)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach {
        println(it.name)
    }

    val kFunction = ::foo
    kFunction.call(43)

    val kProperty = :: counter
    kProperty.setter.call(21)
    println(kProperty.get())

    val memberProperty = Person::age
    println(memberProperty.get(person))
}