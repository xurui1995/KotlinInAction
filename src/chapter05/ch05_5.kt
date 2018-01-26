package chapter05

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow i know the alphabet")
    return result.toString()
}

fun alphabet2(): String {
    val result = StringBuilder()
    with(result) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow i know the alphabet")
        return toString()
    }
}

fun alphabet3() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow i know the alphabet")
    toString()
}

fun alphabet4() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow i know the alphabet")
}.toString()

fun alphabet5() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow i know the alphabet")
}

fun main(args: Array<String>) {
    println(alphabet())
    println(alphabet2())
    println(alphabet3())
    println(alphabet4())
    println(alphabet5())
}