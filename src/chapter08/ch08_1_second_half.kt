package chapter08


enum class Delivery {STANDARD, EXPEDITED}

class Order(val itemCount: Int)

fun getShippingCoastCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return {order ->  6 + 2.1 * order.itemCount}
    }
    return {order -> 1.2 * order.itemCount}
}

data class Person(val firstName: String,
                  val lastName: String,
                  val phoneNumber: String?)

class ContactListFilters{
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = {p: Person -> p.firstName.startsWith(prefix) ||
            p.lastName.startsWith(prefix)}

        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return {startsWithPrefix(it) && it.phoneNumber != null}
    }
}

data class SiteVisit(
        val path: String,
        val duration:Double,
        val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
)

val averageWindowsDuration = log
        .filter { it.os ==  OS.WINDOWS}
        .map (SiteVisit::duration)
        .average()

fun List<SiteVisit>.averageDurationFor(os: OS) =
        filter { it.os == os }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationFor2(predicate: (SiteVisit) -> Boolean) =
        filter ( predicate ).map(SiteVisit::duration).average()


fun main(args: Array<String>) {
    val calculator =
            getShippingCoastCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")

    val contacts = listOf(Person("Dmitry", "Jemerov", "123-4567"),
            Person("Svetlana", "Isakova", null))
    val contactListFilters = ContactListFilters()
    with (contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(
            contactListFilters.getPredicate()))


    println(averageWindowsDuration)

    println(log.averageDurationFor(OS.MAC))

    println(log.averageDurationFor2 {
        it.os == OS.IOS && it.path == "/signup" })

}