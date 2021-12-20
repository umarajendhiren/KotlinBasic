package com.androidapps.basic.kotlinbasics

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}


/*The Delegation pattern has proven to be a good alternative to implementation inheritance, and Kotlin supports it natively requiring zero boilerplate code.

In java if one class is implementing the interface ,we need to override all the methods of interface  even if we are going to send implemented object into the constructor.
1. but in kotlin ,the compiler will generate all the methods of Base that forward to b.that is delegation object.
Delegation means passing the responsibility to another class or method.
 in this way we can avoid most of the boilerplate code


 Kotlin supports “delegation” design pattern by introducing a new keyword “by”. Using this keyword or delegation methodology,
 Kotlin allows the derived class to access all the implemented public methods of an interface through a specific object.

 2.if derived class has it's own methods implementation,compiler will use that existing implementation instead of delegation object implementation.*/


//1
class Derived(b: Base) : Base by b


interface Base1 {
    fun printMessage()  //abstract method
    fun printMessageLine()  //abstract method
}

class BaseImpl1(val x: Int) : Base1 {
    override fun printMessage() {
        print(x)  //implementation of the method
    }

    override fun printMessageLine() {
        println(x)
    }
}

class Derived1(b: Base1) : Base1 by b { // delegating the public method on the object b  ,

    //2
    //this time printMessage() will print  "abc" instead of Baseimpl x value
    override fun printMessage() {
        print("abc")
    }
}



/*property delegation:

Lazy is a lambda function which takes a property as an input and in return gives an instance of Lazy<T>,
where <T> is basically the type of the properties it is using

*In the above piece of code, we are passing a variable “myVar” to the Lazy function,
which in return assigns the value to its object and returns the same to the main function */

val myVar: String by lazy {
    "Hello"
}

fun main() {

    /* val b = BaseImpl(10)
     Derived(b).print()*/



    val b = BaseImpl1(10)
    Derived1(b).printMessage()  //accessing the printMessage() method
    Derived1(b).printMessageLine()

    println(myVar +" My dear friend")
}