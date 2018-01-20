package chapter04

/*
class User(val nickname: String)*/

/*
class User constructor(_nickname: String) {
    val nickname = _nickname
*/
/*    init {
        nickname = _nickname
    }*//*

}*/


fun getFacebookName(accountId: Int) = "fb:$accountId"

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User{
    override val nickname = getFacebookName(accountId)
}

fun main(args: Array<String>) {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)

    val user = User2("Jump")
    user.address = "上海 浦东"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi")
    println("lengthCounter.counter:  ${lengthCounter.counter}")
}

interface User1 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class User2(val name: String) {
    var address: String = "unspecified"
        set(value) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
    private set

    fun addWord(word: String) {
        counter += word.length
    }
}