package chapter02

import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by xur on 2018/1/16.
 */
fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException) {
        return null
    }
    finally {
        reader.close()
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("2**"))
    println(readNumber(reader))
}