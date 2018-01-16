package chapter02

import java.util.*

/**
 * Created by xur on 2018/1/16.
 */
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}


fun main(args: Array<String>) {
/*    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    */
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }

    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    println(isLetter('q'))

    println( recognize('8'))
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "Its a digit"
    in 'a'..'z', in 'A'..'Z' -> "Its a letter"
    else -> "I don't know.."
}
