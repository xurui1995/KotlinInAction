package chapter02

/**
 * Created by xur on 2018/1/16.
 */
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 25);

    fun rgb() = (r * 256 + g) * 256 + b
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr


fun main(args: Array<String>) {
    println(Color.BLUE.rgb())

    println(getMnemonic(Color.BLUE))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}

fun getMnemonic(color: Color) =
        when(color) {
            Color.BLUE -> "Battle"
            Color.RED -> "Richard"
            Color.GREEN -> "Gave"
        }

fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("unknown expression")
    }
