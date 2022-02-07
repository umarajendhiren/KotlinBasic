package com.androidapps.basic.kotlinbasics
/*extension function allow us to extend a class that we don't own or can not modify
* we can add this extension function without the need to inherit from that class
* add functionality that is available in the context of our program only
* ex:if we create the different project ,extended functionality not available for that project(String.extendedfun())
* added code can be called in usual way by declaring objects of that class and invoking methods
* can extend:
* functions
* properties(has some limitation)
* companion object(has limitation)*/

/*extension function:
* can add function to that class that we don't own or can not modify
* can access object using the 'this' reference
* original class not actually modified
* new function are not actually inserted in the class
* rather .,it is a shortcut to make functions available using usual object.function notation*/


/*we can not go and add this slim function with String class.but we can add slim() as extended function of Sting class*/
fun String.slim() = this.substring(1, length - 1)  //remove first and last character of string


fun slim(name: String) {
    var slimmed = name.substring(1, name.length - 1)
    println("slimmed name is $slimmed")
}

/*extension property:
* can add properties to classes, in a similar way functions
* they can not be local like inside function or class
* can only use values 'val' not variables 'var'
* like extension function they are not actually inserted into the class.this is main limitation */

val String.betterLength: Int   //now betterLength is part of string class
    get() {
        println("getting better length")
        return 200
    }

/*Add extension functions to the classes String, Int and Float, that return a custom name for each function.
Call the extension functions and print the names to the console.
*/

fun String.getCustomName() = "String of character"
fun Int.getCustomName() = "An integer number"
fun Float.getCustomName() = "A floating point number"


/*Add an extension function to the ArrayList class that returns a message saying how many elements the list contains.

Create an ArrayList and print out the extension function message.*/

fun ArrayList<String>.sizeOfList() =
    "size of list is ${this.size}"


/*companion object extension:
* if the class has the companion object defined,we can extend it with function and properties
* if not,we can not add companion object through extension(limitation) */

class Book1 {
    //companion object allow us to add static functionality to the class so we can access that companion object functionality through class name without creating object
    companion object {}
}

fun Book1.Companion.printMe() {
    println("Book has been printed ")
}


/*Add a companion object function to the String class that prints out a message saying what type of class this is.
Call the companion object function.
*/
fun String.Companion.getClassType() {
    println("This is string class")
}


/*Add a companion object function to the Double class that prints out the class name.

Call the companion object extension function.*/

fun Double.Companion.getClassType(){
    println("This is double class")
}

fun main(args: Array<String>) {
    var name = "something"
    println(name.slim())  //slim() function now available in String class

/*if we don't have extension concept we need to pass name into slim function then do our logic in that function*/
    slim("something")

    println("micheal".betterLength)

    println("dhfs".getCustomName())
    println(4.getCustomName())
    println(2.5F.getCustomName())

    var list = arrayListOf("efsf", "ert")
    println(list.sizeOfList())

    Book1.printMe()

    String.getClassType()
    Double.getClassType()
}


/*if we wants to add new function to the existing class there is two way available.
*  in java  one is we need to add function with in the same  class
*  or if we want to add outside of class we need to extend that class then we can add whatever we want in subclass.that is inheritance concept.
* in kotlin we can add function for existing class (outside the class) without inheriting them.that is extension function
* To add an extension function to a class, define a new function appended to the classname
*
*  By defining an extension, you are not inserting new members into a class,
* only making new functions callable with the dot-notation on variables of this type.
*
* 1.if member function and extension function has same signature like same name and parameter ,kotlin compiler will omit extension function and call member function only.
* because by default kotlin compiler look for member function first ,if it is not there then only it looks for extension function.
*
*   */


// A sample class to demonstrate extension functions
/*class Circle (val radius: Double){
    // member function of class
    fun area(): Double{
        return Math.PI * radius * radius;
    }

    //1
    fun perimeter(): Double{
        return 2*Math.PI*radius;
    }
}



fun main(){
    // Extension function created for a class Circle
    fun Circle.perimeter(): Double{
        return 2*Math.PI*radius;
    }
    // create object for class Circle
    val newCircle = Circle(2.5);
    // invoke member function
    println("Area of the circle is ${newCircle.area()}")
    //invoke extension function
    println("Perimeter of the circle is ${newCircle.perimeter()}")
}*/


/*2.Extensions are resolved statically
*  which extension function is executed depends totally on the type of the expression on which it is invoked,
* rather than on the type resolved on the final execution of the expression at runtime */

// Open class created to be inherited
/*open class A(val a:Int, val b:Int){

}

// Class B inherits A
class B():A(5, 5){}

fun main(){

    // Extension function operate defined for A
    fun A.operate():Int{
        return a+b
    }

    // Extension function operate defined for B
    fun B.operate():Int{
        return a*b;
    }

    // Function to display static dispatch
    fun display(a: A){
        print(a.operate())
    }

    // Calling display function
    display(B())//here even if we send B instance, Class A operate function will be called .
}*/


/*3.Nullable Receiver –
Extension functions can also be defined with the class type that is nullable.
In this case, when the check for null is added inside the extension function and the appropriate value is returned
.*/

// A sample class to display name name
/*
class AB(val name: String){
    override fun toString(): String {
        return "Name is $name"
    }
}

fun main(){
    // An extension function as a nullable receiver
    fun AB?.output(){
        if(this == null){
            println("Null")
        }else{
            println(this.toString())
        }
    }

    val x = AB("Charchit")

    // Extension function called using an instance
    x.output()
    // Extension function called on null
    null.output()
}
*/


/*4.Just like the calling of regular member function of the companion object,
 extension function can be called using only the class name as the qualifier*/


class MyClass {
    companion object {
        // member function of companion object
        fun display(str: String): String {
            return str
        }
    }
}

// extension function of companion object
fun MyClass.Companion.abc() {
    println("Extension function of companion object")
}

/*fun main(args: Array<String>) {
    val ob = MyClass.display("Function declared in companion object")
    println(ob)
    // invoking the extension function
    val ob2 = MyClass.abc()
}*/


