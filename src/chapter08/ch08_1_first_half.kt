package chapter08

fun performRequest(
        url: String,
        callback: (code: Int, content: String) -> Unit
) {
    callback(2,"3")
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
/*    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }*/
    (0 until length)
            .map { get(it) }
            .filter { predicate(it) }
            .forEach { sb.append(it) }
    return sb.toString()
}

fun <T> Collection<T>.joinToString(
        separator: String = ",",
        prefix: String = "",
        postfix: String = "",
        transform: (T) -> String = {it.toString()}
): String {
    val result = StringBuilder(prefix)
    forEachIndexed { index, t ->
        if (index > 0)
            result.append(separator)
        result.append( transform(t))
    }
    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToString2(
        separator: String = ",",
        prefix: String = "",
        postfix: String = "",
        transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)
    forEachIndexed { index, t ->
        if (index > 0)
            result.append(separator)
        result.append( transform?.invoke(t)?: t.toString())
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val url = "http://kotl.in"
    performRequest(url) {code, content -> println(code*2 + content.toInt()) }

    twoAndThree{a, b -> a + b}
    twoAndThree{a, b -> a * b}

    println("abc1d".filter { it in 'a'..'z' })

    println("abc1d".filter { it -> it in 'a'..'z' })

    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString(separator = "-"))
    println(letters.joinToString(separator = "-"){
        it.toLowerCase()
    })
    println(letters.joinToString2())
}