package chapter06

fun strLenSafe(s: String?): Int =
    // if (s != null) s.length else 0
        s?.length ?: 0

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String ,val zipCode: Int,
              val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

class Person2(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person2 ?: return false
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}

fun printShippingLabel(person: Person) {
    val address = person.company?.address
            ?: throw IllegalArgumentException("No address")

    with(address) {
        println(streetAddress)
        println("$zipCode $city , $country")
    }
}

fun Person.countryName(): String {
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}

fun main(args: Array<String>) {
    val x: String? = null
    println(strLenSafe(x))

    printAllCaps("ABC")
    printAllCaps(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    val person = Person("Dmitry", null)
    println(person.countryName())

    val person2 : Person? =  null
    println(person2?.countryName())

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person3 = Person("Dmitry", jetbrains)
    printShippingLabel(person3)
    // printShippingLabel(Person("Alexey", null))

    val p1 = Person2("Dmitry", "Jemerov")
    val p2 = Person2("Dmitry", "Jemerov")
    println(p1 == p2)
    println(p1.equals(42))



}