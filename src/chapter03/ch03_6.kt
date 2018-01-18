package chapter03

import org.omg.CORBA.FieldNameHelper

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    /*if (user.name.isEmpty()) {
        throw IllegalArgumentException(
                "cant save user $user.id  : empty name"
        )
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
                "cant save user $user.id  : empty address"
        )
    }*/

    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                    "cant save user ${user.id}  : empty $fieldName"
            )
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun main(args: Array<String>) {
    saveUser(User(1,"",""))
}

