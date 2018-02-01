package chapter07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Email

fun loadEmails(person: Person2): List<Email> {
    println("load emails for ${person.name}")
    return listOf()
}

class Person2(val name: String) {
    private var _emails: List<Email>? = null

    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }
            return _emails!!
        }
    val lazyEmails by lazy { loadEmails(this) }
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun  addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }

}

class Person3(val name: String, age: Int, salary: Int
): PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) { _salary.setValue(value) }

}

class ObservableProperty(val propName: String, var propValue: Int,
                         val changeSupport: PropertyChangeSupport) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class ObservableProperty2( var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: Person4, prop: KProperty<*>) : Int = propValue
    operator fun setValue(p: Person4, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class Person4(
        val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    var age: Int by ObservableProperty2(age, changeSupport)
    var salary: Int by ObservableProperty2(salary, changeSupport)
}

class Person5(
        val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

class Person6 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes
       // get() = _attributes["name"]!!
}
fun main(args: Array<String>) {
    val p = Person2("Jump")
    p.emails
    p.emails
    println("-".repeat(10))
    p.lazyEmails
    p.lazyEmails

    val p3 = Person3("Jump",12,100)
    p3.addPropertyChangeListener(PropertyChangeListener {
            println("Property ${it.propertyName} changed " +
                    "from ${it.oldValue} to ${it.newValue}")
     })

    p3.age = 100
    p3.salary = 200

    println("-".repeat(10))

    val p4 = Person4("Dmitry", 34, 2000)
    p4.addPropertyChangeListener(
            PropertyChangeListener { event ->
                println("Property ${event.propertyName} changed " +
                        "from ${event.oldValue} to ${event.newValue}")
            }
    )
    p4.age = 35
    p4.salary = 2100

    println("-".repeat(10))

    val p5 = Person5("Allen", 34, 2000)
    p5.addPropertyChangeListener(
            PropertyChangeListener { event ->
                println("Property ${event.propertyName} changed " +
                        "from ${event.oldValue} to ${event.newValue}")
            }
    )
    p5.age = 35
    p5.salary = 2100


    val p6 = Person6()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
    for ((attrName, value) in data)
        p6.setAttribute(attrName, value)
    println(p6.name)

}