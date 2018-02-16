package chapter09

fun main(args: Array<String>) {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(10..13))

    println(listOf(1, 2, 3, 4).penultimate)

    println(oneHalf(5))

    println(max("kotlin", "java"))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
}

val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun <T: Number> oneHalf(value: T): Double = value.toDouble() / 2.0

fun <T: Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T)
    where T : CharSequence, T: Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}
