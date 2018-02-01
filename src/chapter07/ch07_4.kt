package chapter07

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

data class NameComponents(val name: String,
                          val extension: String)

fun splitFilename(fullName: String): NameComponents {
   /* val result = fullName.split(".", limit = 2)
    return NameComponents(result[0], result[1])*/
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

fun main(args: Array<String>) {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)

    val p = Point(10, 20)
    val (x, y) = p
    println("Point x:" + x)

    val (name, ext) = splitFilename("example.kt")
    println(name)
    println(ext)
}
