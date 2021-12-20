package com.androidapps.basic.kotlinbasics

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class  DelegatedProperty {
    /*it is more helpful to implement them once, add them to a library, and reuse them later.
* The syntax is: val/var <property name>: <Type> by <expression>
The expression after by is a delegate, because the get() (and set()) that correspond to the property will be delegated to its getValue() and setValue() methods*/
    var p: String by Delegate()

}

    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }






/*Lazy properties: the value is computed only on first access.

   lazy() is a function that takes a lambda and returns an instance of Lazy<T>,
    which can serve as a delegate for implementing a lazy property.
    The first call to get() executes the lambda passed to lazy() and remembers the result.
   Subsequent calls to get() simply return the remembered result.

   By default, the evaluation of lazy properties is synchronized:
   the value is computed only in one thread, but all threads will see the same value*/

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}








/*Observable properties: listeners are notified about changes to this property.
Delegates.observable() takes two arguments: the initial value and a handler for modifications.

The handler is called every time you assign to the property (after the assignment has been performed).
It has three parameters: the property being assigned to, the old value, and the new value:*/
class User {
    var name: String by Delegates.observable("<no name>") {
            prop, old, new ->
        println("$old -> $new")
    }
}







/*Storing properties in a map:
Storing properties in a map instead of a separate field for each property.
One common use case is storing the values of properties in a map.
This comes up often in applications for things like parsing JSON or performing other dynamic tasks.
In this case, you can use the map instance itself as the delegate for a delegated property.*/

class UserUsingMap(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}




fun main() {
    val delegatedPropertyInstance=DelegatedProperty()

    /*when we call this property ,that will call getValue() method of Delegate class
    *  Its first parameter is the object you read p from, and the second parameter holds a description of p itself*/

    println(delegatedPropertyInstance.p)

    /*Similarly, when you assign to p, the setValue() function is called.
    * here first two parameters are the same, and the third holds the value being assigned*/
    delegatedPropertyInstance.p="New"







    println(lazyValue)
    println(lazyValue)



    val user=User()
    user.name = "first"
    user.name = "second"




    val user1 = UserUsingMap(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))
    println(user1.name) // Prints "John Doe"
    println(user1.age)  // Prints 25
}