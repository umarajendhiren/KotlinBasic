package com.androidapps.basic.kotlinbasics

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
        fun display(str :String) : String{
            return str
        }
    }
}
// extension function of companion object
fun MyClass.Companion.abc(){
    println("Extension function of companion object")
}
fun main(args: Array<String>) {
    val ob = MyClass.display("Function declared in companion object")
    println(ob)
    // invoking the extension function
    val ob2 = MyClass.abc()
}


