package com.androidapps.basic.kotlinbasics

//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
/*class is a blue print it allow us to create object
* class can have variables and functions
* if we declare the variable in class context,that will available within class.All methods defined inside class can access that variable.
* if we wants to access class component (function,variable) we need to create class instance (object)
* object is an instance of the class ex:val carObj=Car()
* Naming convention :Class name should starts with a capital letter*/

/*Classes in Kotlin are declared using the keyword class:

 The class declaration consists of the class name, the class header (specifying its type parameters, the primary constructor, and some other things),
 and the class body surrounded by curly braces. Both the header and the body are optional;
 if the class has no body, the curly braces can be omitted.


 */

/*A class in Kotlin can have a primary constructor and one or more secondary constructors.
 The primary constructor is a part of the class header, and it goes after the class name and optional type parameters.
*/
class Person constructor(firstName: String)


/*If the primary constructor does not have any annotations or visibility modifiers, the constructor keyword can be omitted:*/
class Person1(firstName: String) { /*...*/ }

/*If the constructor has annotations or visibility modifiers,
 the constructor keyword is required and the modifiers go before it:*/

//class Customer public @Inject constructor(name: String) { /*...*/ }

/*The primary constructor cannot contain any code.
 Initialization code can be placed in initializer blocks prefixed with the init keyword.

 During the initialization of an instance, the initializer blocks are executed in the same order
 as they appear in the class body, interleaved with the property initializers:*/


class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}


/*A class can also declare secondary constructors, which are prefixed with constructor:
Much like regular properties, properties declared in the primary constructor can be mutable (var) or read-only (val).*/


class Person2(val name: String) {
    val children: MutableList<Person2> = mutableListOf()

    constructor(name: String, parent: Person2) : this(name) {
        parent.children.add(this)
    }
}


/*If you don't want your class to have a public constructor,
declare an empty primary constructor with non-default visibility:*/

class DontCreateMe private constructor() { /*...*/ }


/*Creating instances of classes
To create an instance of a class, call the constructor as if it were a regular function:
Kotlin does not have a new keyword.*/

val customer = Person2("Joe Smith")

/*Class members:
Classes can contain:

Constructors and initializer blocks
Functions
Properties
Nested and inner classes
Object declarations*/

/*Abstract classes:
A class may be declared abstract, along with some or all of its members. An abstract member does not have an implementation in its class.
 You don't need to annotate abstract classes or functions with open.*/

abstract class Polygon {
    abstract fun draw() //function without body should be abstract method.
    fun nonAbstractfun() {

    }

}

class Rectangle : Polygon() {
    override fun draw() {
        // draw the rectangle
    }
}


fun main() {
    InitOrderDemo("hello")
}
