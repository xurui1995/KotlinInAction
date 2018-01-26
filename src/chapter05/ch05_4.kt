package chapter05


fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}
fun main(args: Array<String>) {
    createAllDoneRunnable()
}