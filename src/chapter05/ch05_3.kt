package chapter05

import java.io.File

fun File.isInsideHiddenDirectory() =
        generateSequence(this) { it.parentFile }.any { it.isHidden }

fun main(args: Array<String>) {
    listOf(1, 2, 3, 4).asSequence()
            .map { println("map($it)"); it * it }
            .filter { println("filter($it)"); it % 2 == 0 }

    listOf(1, 2, 3, 4).asSequence()
            .map { println("map($it)"); it * it }
            .filter { println("filter($it)"); it % 2 == 0 }
            .toList()

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    val file = File("/Users/svtk/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory())
}