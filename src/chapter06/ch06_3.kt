package chapter06

import chapter02.isNotDigit
import java.io.BufferedReader
import java.io.File
import java.io.StringReader

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) {
            sumOfValidNumbers +=number
        } else {
            invalidNumbers++
        }
    }
    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

fun addValidNumbers2(numbers: List<Int?>) {
    println("addValidNumbers2()")
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun <T> copyElements(source: Collection<T>,
                     target: MutableCollection<T>) {
    for (item in  source) {
        target.add(item)
    }
}
fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    println(numbers)
    addValidNumbers(numbers)

    addValidNumbers2(numbers)

    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int?> = arrayListOf(1)
    copyElements(source, target)
    println(target)

    println(args)
    for (i in args.indices) {
        println("Argument $i is: ${args[i]}")
    }

    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))

    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))

    args.forEachIndexed { index, element ->
        println("Argument $index is: $element")
    }
}