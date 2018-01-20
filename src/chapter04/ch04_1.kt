package chapter04

import java.io.Serializable

interface Clickable {
    fun click()
    fun showOff() = println("im clicked")
}

interface Focusable {
    fun setFocus(b: Boolean) =
            println("i ${if (b) "got" else "losed"} focus")

    fun showOff() = println("im focusable")
}
class Button : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }



    override fun click() {
        println("i was clicked")
    }

}

fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}

open class RichButton : Clickable {
    override fun click() {}
    fun disable() {}
    open fun animate() {}
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}

    fun animateTwice() {

    }
}

interface State: Serializable
interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

class Button1: View {
    override fun restoreState(state: State) {

    }

    override fun getCurrentState() = ButtonState()

    class ButtonState : State
}

class Outer {
    inner class Inner {
        fun getOuterReference() : Outer = this@Outer
    }
}

/*
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right:Expr) : Expr

fun eval(e: Expr) : Int =
        when(e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
            else ->
                    throw  IllegalArgumentException()
        }*/

sealed class Expr {
    class Num(val value: Int): Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
        when(e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.left) + eval(e.right)
        }