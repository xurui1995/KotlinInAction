package chapter09

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>
            ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun printSum2(c: Collection<Int>) {
    if (c is List<Int>) {
        println("----")
        println(c.sum())
    }
}

inline fun <reified T> isA(value: Any) = value is T

fun main(args: Array<String>) {
   // printSum(listOf("1", "2", "3"))
    printSum2(listOf(1, 2, 3))

    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())

}