package chapter07

import java.math.BigDecimal

data class Point(val x: Int, val y: Int) {
/*    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }*/
}

operator fun Point.plus(other: Point) = Point(x + other.x, y + other.y)

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(20, 20)
    println(p1 + p2)

    println(p1 * 1.5)
    println('a'* 5)

    println(0x0F and 0xF0)
    println(0x0F or 0xF0)
    println(0x1 shl 4)

    var point = Point(1, 2)
    point += Point(3, 4)
    println(point)

    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)

    val p3 =  Point(10 ,20)
    println(-p3)

    var bd = BigDecimal.ZERO
    println(bd++)
    println(++bd)
}