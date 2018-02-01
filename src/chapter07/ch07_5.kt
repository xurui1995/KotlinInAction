package chapter07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.util.*

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

    fun  addProprtryChangeListener(listener: PropertyChangeListener) {
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

}

fun main(args: Array<String>) {
    val p = Person2("Jump")
    p.emails
    p.emails
    println("-".repeat(10))
    p.lazyEmails
    p.lazyEmails

    val p3 = Person3("Jump",12,100)
    p3.addProprtryChangeListener(PropertyChangeListener {
            println("Property ${it.propertyName} changed " +
                    "from ${it.oldValue} to ${it.newValue}")
     })

    p3.age = 100
}