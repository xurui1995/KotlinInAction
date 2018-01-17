package chapter03

fun <T> Collection<T>.joinToString(
        separator: String = ",",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if(index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


fun String.lastChar(): Char = this.get(this.length - 1)

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I am a view")
fun Button.showOff() = println("I am a button")

fun main(args: Array<String>) {
    val list = arrayListOf(1, 2, 3)
    println(list.joinToString(" "))

    println("Kotlin".lastChar())

    val view: View = Button()
    view.click()
    view.showOff()
}