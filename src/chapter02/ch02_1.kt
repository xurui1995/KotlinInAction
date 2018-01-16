package chapter02

/**
 * Created by xur on 2018/1/16.
 */
fun main(args: Array<String>) {
    println("Hello, world")

    println(max(8, 0))

    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello $name")

}
fun  max(a: Int, b: Int): Int {
    return if (a>b) a else b
}
