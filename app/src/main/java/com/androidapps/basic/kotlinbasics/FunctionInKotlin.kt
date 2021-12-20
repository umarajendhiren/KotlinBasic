package com.androidapps.basic.kotlinbasics

/*A function is a unit of code that performs a special task.
In programming, function is used to break the code into smaller modules which makes the program more manageable.*/
/*In kotlin ,functions are declared using fun keyword
* Function parameters are defined using Pascal notation - name: type.
*  Parameters are separated using commas, and each parameter must be explicitly typed:*/
fun powerOf(number: Int, exponent: Int): Int {
    return 2;
}

/*Default arguments:
Function parameters can have default values, which are used when you skip the corresponding argument.
This reduces the number of overloads:
A default value is defined using = after the type.

in java,if function has 2 parameters,always we have to send 2 parameters.

for ex,i have two scenario.first scenario is ,user should able to login using username and password.
second scenario is ,user can also able to put his email when login  for verification and it is optional.
for this two scenario,i have to use overloading concept.like

login(username,password);
login(username,password,emailId);

but in kotlin we no need to create n number of overload.we can use default parameter concept.

if user did not write email id when login,default value will be  used otherwise user mail id will be used.
 */

fun login(username: String, password: String, emailId: String = "optionalEmailId") {
    println(" $username $password $emailId")
}


/*Overriding methods always use the same default parameter values as the base method.
 When overriding a method that has default parameter values,
the default parameter values must be omitted from the signature:*/

open class BaseA {
    open fun foo(i: Int = 10) { /*...*/
    }
}

class ChildB : BaseA() {
    override fun foo(i: Int) { /*...*/
    }  // No default value is allowed.
}


/*if my first parameter has no default value ,second parameter has default value ,we can pass only one parameter(for first).
if my first argument has default value,second parameter with no default value .compiler tell us to pass all parameters.
* To use default value ,we need to use named argument.*/

fun loginDefaultValueFirst(
    emailId: String = "optionalEmailId",
    username: String,
    password: String
) {
    println(" $username $password $emailId")
}


/*If the last argument after default parameters is a lambda,
 you can pass it either as a named argument or outside the parentheses:*/
fun foo(
    bar: Int = 0,
    baz: Int = 1,
    qux: () -> Unit,
) {

}


/*Named arguments:
When calling a function, you can name one or more of its arguments.
 This can be helpful when a function has many arguments and
 it's difficult to associate a value with an argument, especially if it's a boolean or null value.

When you use named arguments in a function call, you can freely change the order they are listed in,
 and if you want to use their default values, you can just leave these arguments out altogether.

 for ex,in java ,i have function SaveMyDetails(String username,String password,String UserEmailId,String address)
 i always need to pass argument as the same order in funtion like first username,second password..
 but in kotlin ,using named argument,we can freely change the order of argument

  loginDefaultValueFirst(password = "pass",username = "ums" )
 */


/*Unit-returning functions:
If a function does not return a useful value, its return type is Unit.
 Unit is a type with only one value - Unit. This value does not have to be returned explicitly:*/

fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional

}

//The Unit return type declaration is also optional. The above code is equivalent to:
//fun printHello(name: String?) {  }



/*
Single-expression functions
When a function returns a single expression,
the curly braces can be omitted and the body is specified after a = symbol:
 */


fun double(x: Int): Int = x * 2


//Explicitly declaring the return type is optional when this can be inferred by the compiler:

//fun double(x: Int) = x * 2


/*Explicit return types:
Functions with block body must always specify return types explicitly,
 unless it's intended for them to return Unit, in which case specifying the return type is optional.



Kotlin does not infer return types for functions with block bodies because
 such functions may have complex control flow in the body,
 and the return type will be non-obvious to the reader (and sometimes even for the compiler)

 if the function is Single-expression functions,we no need to explicitly mention return type.*/


/*Variable number of arguments (varargs):
You can mark a parameter of a function (usually the last one) with the vararg modifier:
In this case, you can pass a variable number of arguments to the function:
Inside a function, a vararg -parameter of type T is visible as an array of T,
as in the example above, where the ts variable has type Array<out T>

Only one parameter can be marked as vararg. If a vararg parameter is not the last one in the list,
values for the subsequent parameters can be passed using named argument syntax,
 or, if the parameter has a function type, by passing a lambda outside the parentheses.

When you call a vararg -function, you can pass arguments individually, for example asList(1, 2, 3).
 If you already have an array and want to pass its contents to the function,
  use the spread operator (prefix the array with *):.*/

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}


/*Infix notation:
Functions marked with the infix keyword can also be called using the infix notation (omitting the dot and the parentheses for the call).
 Infix functions must meet the following requirements:

They must be member functions or extension functions.

They must have a single parameter.

The parameter must not accept variable number of arguments and must have no default value.*/

//member function
class MyStringCollection {
    infix fun add(s: String) { /*...*/
    }

    fun build() {
        this add "abc"   // Correct
        add("abc")       // Correct
        //add "abc"        // Incorrect: the receiver must be specified
    }
}

//extension function
infix fun Int.shl(x: Int): Int {
    return 1;
}


/*Function scope:
Kotlin functions can be declared at the top level in a file,
meaning you do not need to create a class to hold a function,
which you are required to do in languages such as Java, C#, and Scala. In addition to top level functions,
 Kotlin functions can also be declared locally as member functions and extension functions.

Local function:
 function inside another function

member function :
 A member function is a function that is defined inside a class or object:

Generic functions:
Functions can have generic parameters, which are specified using angle brackets before the function name:
fun <T> singletonList(item: T): List<T> { /*...*/ }

top level functions:
Kotlin functions can be declared at the top level in a file,
meaning you do not need to create a class to hold a function

extension functions:
 Function for the class and declared outside the class without using inheritance concept

 A higher-order function is a function that takes functions as parameters, or returns a function.


 */




fun main() {
    login("uma", "myPassword")
    login("uma", "myPass", "myMailId")

    loginDefaultValueFirst("mail", "uma", "pass")
    loginDefaultValueFirst(username = "ums", password = "pass")
    loginDefaultValueFirst(password = "passss", username = "ums")

    foo(1) { println("hello") }     // Uses the default value baz = 1
    foo(qux = { println("hello") }) // Uses both default values bar = 0 and baz = 1
    foo { println("hello") }        // Uses both default values bar = 0 and baz = 1


    /*When you call a vararg -function, you can pass arguments individually, for example asList(1, 2, 3).
     If you already have an array and want to pass its contents to the function,
      use the spread operator (prefix the array with *):*/
    val a = arrayOf(1, 2, "kk")
    val list1 = asList(-1, 0, *a, 4)
    println(list1)

    /*If you want to pass a primitive type array into vararg,
     you need to convert it to a regular (typed) array using the toTypedArray() function:*/
    val b = intArrayOf(1, 2, 3) // IntArray is a primitive type array
    val list2 = asList(-1, 0, *b.toTypedArray(), 4)
    println(list2)


    // calling the function using the infix notation
    1 shl 2

// is the same as
    1.shl(2)

}