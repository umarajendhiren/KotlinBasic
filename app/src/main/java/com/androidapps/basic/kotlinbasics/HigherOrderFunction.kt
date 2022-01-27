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
var lambda = { println("GeeksforGeeks: A Computer Science portal for Geeks") }

// higher-order function
fun higherfunc(lmbd: () -> Unit) {     // accepting lambda as parameter
    lmbd()                               //invokes lambda expression

    /*lmbd: () -> Unit
lmbd is local name for the receiving lambda parameter.
() represents that the function does not accept any arguments.
Unit represents that function does not return any value.*/
}


//Kotlin program of lambda expression which returns Integer value –
// lambda expression
var lambdaex = { a: Int, b: Int -> a + b }

// higher order function
fun higherfunc(lmbd: (Int, Int) -> Int) {      // accepting lambda as parameter

    var result = lmbd(2, 4)    // invokes the lambda expression by passing parameters
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
fun printMe(s: String): Unit {
    println(s)
}

// higher-order function definition
fun higherfunc(str: String, myfunc: (String) -> Unit) {
    // invoke regular function using local name
    myfunc(str)
}

//Kotlin program of passing function which returns integer value-
// regular function definition
fun add(a: Int, b: Int): Int {
    var sum = a + b
    return sum
}

// higher-order function definition
fun higherOrderfunc(addfunc: (Int, Int) -> Int) {
    // invoke regular function using local name
    var result = addfunc(3, 6)
    print("The sum of two numbers is: $result")
}


/*Returning a function from Higher-Order function
We can return a function from higher-order function. While returning the function,
we have to specify the parameter types and return type of regular function in the return type of the higher-order function. */


//Kotlin program of a function returning another function-

// function declaration
fun mul(a: Int, b: Int): Int {
    return a * b
}

//higher-order function declaration
fun higherfunc(): ((Int, Int) -> Int) {
    return ::mul
    //::mul represents that it return mul() function
    //(Int,Int) represents that mul accepts two integer type parameters
    //Int represents that mul returns an integer value.
}

/*this higher order function takes two parameters one is collection and another is lambda
* doSomething is lambda function and accepts string as parameter and returns nothing
* Unit is a keyword that says, this function doesn't return value*/
fun exampleHOF1(names: Collection<String>, doSomething: (String) -> Unit) {

    for (name in names) {
        doSomething(name)
    }


}


/*Create a Higher Order Function that takes a mutable collection of integers and a lambda function.
 It then applies the lambda function to every even element of that collection.
Create a lambda function that when applies to an integer, it returns that integer divided by 10.
Call the HOF using your lambda and display the result.
*/

fun exampleHOF2(numbers: ArrayList<Int>, dividedByTen: (Int) -> Int): ArrayList<Int> {
    /*  var result = arrayListOf<Int>()
      for (number in numbers) {
          if (number % 2 == 0) {
              //even number
              result.add(dividedByTen(number))
          }
      }
  return result*/


    /*instead of creating new list we can update result in same arrayList*/
    for (i in 0..numbers.size - 1) {
        if (numbers[i] % 2 == 0) {
            numbers[i] = dividedByTen(numbers[i])
        }
    }
    return numbers

}


/*Create a Higher Order Function that takes a list of client names and a lambda expression that returns a String.

It then applies the lambda expression to every client name, creates a new collection of the results and returns the result.

Create a lambda expression that takes a client name String and returns a personalised message.

Call the HOF and print out the result.*/

fun exampleHOF3(
    clientsName: Collection<String>,
    greetingLmd: (String) -> String
): Collection<String> {
    var result = arrayListOf<String>()
    for (clientName in clientsName) {
        result.add(greetingLmd(clientName))
    }
    return result
}

fun printOnlyTwoDigitNumbers() {
    var numbers = setOf(1, 5, 10, 56, 89, 100, 5656, 7, 876)
    println(numbers.filter { it in 10..99 })


}

fun sortByLastLetter() {
    var names = listOf("dfd", "dth", "yuyu")
    println(names.sortedBy { it[it.length - 1] })  //it will give last letter of string
}

fun biggestMiddleDigit() {
    var numbers = listOf(134, 167, 298, 125)
    var biggest = 0

    numbers.maxByOrNull { it.toString()[1].toInt() }

    //another way
    println(numbers.maxByOrNull { it / 10 % 10 }) //give middle element
}


/*Given a collection of random integers.

If a number is odd, double it.

If a number is even, half it.

Print out a subset of the collection that has numbers greater than 25.*/

fun exampleHOF() {
    var number = listOf(6, 5, 8, 3,15,16)

    val subset = number.map {
        if (it % 2 == 0) it / 2
        else it * 2
    }
        .filter { it>25 }

    println(subset)  //only prints [30]
}

fun main(args: Array<String>) {
    //invoke higher-order function
    higherfunc(lambda)                 // passing lambda as parameter

    higherfunc(lambdaex)           //passing lambda as parameter

    // invoke higher-order function
    higherfunc(
        "GeeksforGeeks: A Computer Science portal for Geeks",
        ::printMe
    )  //regular function as parameter

    higherOrderfunc(::add)

    // invoke function and store the returned function into a variable
    val multiply = higherfunc()
    // invokes the mul() function by passing arguments
    val result = multiply(2, 4)
    println("The multiplication of two numbers is: $result")


    /*list of names*/
    var names = listOf("dmf", "ff", "yuy")
    /*doSomething lambda function */
    var doSomethingLambda = { name: String -> println("Hello $name") }
    // exampleHOF1(names,doSomethingLambda)

    /*another way is we can directly pass lambda function instead of creating variable to holds lambda result(memory efficient)
    * convention is ,if we are directly sending lambda function as parameter ,we can put that lambda outside parenthesis*/
    /* exampleHOF1(names)
     {name:String-> println("Hello $name")}*/

    /*another way*/
    exampleHOF1(listOf("dmf", "ff", "yuy"))
    { name: String -> println("Hello $name") }

    var resultDivideByTen =
        exampleHOF2(arrayListOf(4, 8, 10, 60, 15)) { evenNumber: Int -> evenNumber / 10 }
    println(resultDivideByTen)


    var greetingResult =
        exampleHOF3(listOf("hgfh", "dfgfd", "dgf")) { name: String -> "Hello $name" }
    println(greetingResult)


    /*common HOFs*/

    var clients = listOf("Anna", "Bob", "Carol", "Dan")
    clients.forEach { println("Hello $it") }
    println()

    /*filter return a collection that  passed given condition
    * takes each element from collection and apply filter for each element */
    clients.filter { it.length < 5 }
        .forEach { println("Hello $it") }
    println()

    /*map create a collection based on the predicate*/
    var size = clients.map { it.length }
    println(size)

    /*sortBy define the way to sort our list*/
    var sorted = clients.sortedBy { it.length }
    println(sorted)

    var maxBy = clients.maxByOrNull { it.length }
    println(maxBy) //carol(last occurrence)

    var minBy = clients.minByOrNull { it.length }
    println(minBy)  //bob(first occurrence)


    printOnlyTwoDigitNumbers()
    sortByLastLetter()
    biggestMiddleDigit()
    exampleHOF()

}