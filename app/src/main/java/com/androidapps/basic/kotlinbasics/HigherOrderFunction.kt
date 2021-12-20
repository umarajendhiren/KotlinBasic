package com.androidapps.basic.kotlinbasics


/*Kotlin functions can be stored in variables and data structures, passed as arguments to and returned from other higher-order functions.
* In Kotlin, a function which can accepts a function as parameter or
* can returns a function is called Higher-Order function.
* Instead of Integer, String or Array as a parameter to function,
* we will pass anonymous function or lambdas.
*  Frequently, lambdas are passed as parameter in Kotlin functions for the convenience. */

/*Passing lambda expression as a parameter to Higher-Order Function –
We can pass a lambda expression as a parameter to Higher-Order Function.
There are two types of lambda expression which can be passed-

Lambda expression which return Unit
Lambda expression which return any of the value integer,string etc
 */

//Kotlin program of lambda expression which returns Unit-


// lambda expression
var lambda = {println("GeeksforGeeks: A Computer Science portal for Geeks") }
// higher-order function
fun higherfunc( lmbd: () -> Unit ) {     // accepting lambda as parameter
    lmbd()                               //invokes lambda expression

    /*lmbd: () -> Unit
lmbd is local name for the receiving lambda parameter.
() represents that the function does not accept any arguments.
Unit represents that function does not return any value.*/
}



//Kotlin program of lambda expression which returns Integer value –
// lambda expression
var lambdaex = {a: Int , b: Int, -> a + b }
// higher order function
fun higherfunc( lmbd: (Int, Int,) -> Int) {      // accepting lambda as parameter

    var result = lmbd(2,4)    // invokes the lambda expression by passing parameters
    println("The sum of two numbers is: $result")

    /*lmbd: (Int, Int) -> Int
lmbd is local name for the receiving lambda parameter.
(Int,Int) represents that function accepts two integer type parameters.
-> Int represents that function returns an integer value.*/
}



/*Passing function as a parameter to Higher-Order function –
We can pass a function as a parameter in Higher-Order function.
There are two types of functions which can be passed-

function which return Unit
function which return any of the value integer, string etc*/

//Kotlin program of passing function which returns Unit-

// regular function definition
fun printMe(s:String): Unit{
    println(s)
}
// higher-order function definition
fun higherfunc( str : String, myfunc: (String) -> Unit){
    // invoke regular function using local name
    myfunc(str)
}

//Kotlin program of passing function which returns integer value-
// regular function definition
fun add(a: Int, b: Int): Int{
    var sum = a + b
    return sum
}
// higher-order function definition
fun higherOrderfunc(addfunc:(Int,Int)-> Int){
    // invoke regular function using local name
    var result = addfunc(3,6)
    print("The sum of two numbers is: $result")
}



/*Returning a function from Higher-Order function
We can return a function from higher-order function. While returning the function,
we have to specify the parameter types and return type of regular function in the return type of the higher-order function. */


//Kotlin program of a function returning another function-

// function declaration
fun mul(a: Int, b: Int): Int{
    return a*b
}
//higher-order function declaration
fun higherfunc() : ((Int,Int)-> Int){
    return ::mul
    //::mul represents that it return mul() function
    //(Int,Int) represents that mul accepts two integer type parameters
    //Int represents that mul returns an integer value.
}

fun main(args: Array<String>) {
    //invoke higher-order function
    higherfunc(lambda)                 // passing lambda as parameter

    higherfunc(lambdaex)           //passing lambda as parameter

    // invoke higher-order function
    higherfunc("GeeksforGeeks: A Computer Science portal for Geeks",::printMe)  //regular function as parameter

    higherOrderfunc(::add)

    // invoke function and store the returned function into a variable
    val multiply = higherfunc()
    // invokes the mul() function by passing arguments
    val result = multiply(2,4)
    println("The multiplication of two numbers is: $result")
}