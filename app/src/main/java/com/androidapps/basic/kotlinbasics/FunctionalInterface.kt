package com.androidapps.basic.kotlinbasics

/*An interface with only one abstract method is called a functional interface, or a Single Abstract Method (SAM) interface.
The functional interface can have several non-abstract members but only one abstract member.

To declare a functional interface in Kotlin, use the fun modifier.*/

fun interface KRunnable {
    fun invoke()
}


/*SAM conversions
For functional interfaces, you can use SAM conversions that help make your code more concise and readable by using lambda expressions.

Instead of creating a class that implements a functional interface manually, you can use a lambda expression.
With a SAM conversion, Kotlin can convert any lambda expression whose signature matches the signature of the interface's single method into the code,
which dynamically instantiates the interface implementation.*/

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate { it % 2 == 0 }

fun main() {
    println("Is 7 even? - ${isEven.accept(7)}")
}

//If you don't use a SAM conversion, you will need to write code like this:

// Creating an instance of a class
val isEvenNum = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}