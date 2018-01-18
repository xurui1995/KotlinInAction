package chapter03

fun main(args: Array<String>) {
    val a: Array<String> = arrayOf("1","2")
    val list = listOf("args: ",*a)
    println(list)
}