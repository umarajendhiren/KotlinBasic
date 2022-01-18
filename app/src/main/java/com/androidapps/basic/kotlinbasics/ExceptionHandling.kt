package com.androidapps.basic.kotlinbasics

import java.lang.IllegalStateException

/*exception is an unexpected event in a program
* the System can not recover from exception
* execution is stooped and data is lost
* cause very bad user experience
* for instance i use readLine() fun for read user input from console and i try to convert user input into integer using readline().toInt()
* if user entered text instead of number i will get "numberformatexception" because system don't know how to convert text to integer
*
* general structure of exception:
* exception always have a message and stack trace
* stack trace is a log of what the program did before it reached this point.
* optionally has a cause*/

/*Try-catch:
* A way to manage the exception
* we try to run block of code
* if an exception occurs,the code in the catch will be run
* execution can continue*/



fun main() {

    //tryCatchWithoutFinally()
    // tryCatchWithFinally()

    //generateOwnException()

    //exercise()

    exercise1()
}

fun exercise1() {
    try {
        println("what product do you want?")
        var productName = readLine()
        println("How many products would you like?")
        var count = readLine()?.toInt() //this line produce exception

        println("Total for $count $productName is ${count?.times(10)}")
        println("Transaction completed!")
    } catch (e: java.lang.Exception) {
        println("Please enter valid count!")

    } finally {
        println("Thank You!")
    }
}

fun exercise() {


    /*read data from console and convert to integer
    * if possible ,multiply by 5 and print
    * if an exception occurs,catch it and print meaningful message*/
    try {
        println("enter number:")

        var enteredInput = readLine()?.toInt() //if user enter text ,this line throw exception

        println(enteredInput?.times(5))  //this line of code will be executed only if there is no exception
    } catch (e: Exception) {
        println("you have entered text instead of number.try again! ")
    }
}

fun generateOwnException() {
    /*This is the way of generating own exceptions
    * Using the keyword "throw"*/

    println("enter number:")
    val enteredInput = readLine()
    throw IllegalStateException("I don't like this input")
}


/*finally:
* finally block will be executed whether or not exception occurs*/
fun tryCatchWithFinally() {
    println("enter number:")
    try {
        val enteredInput = readLine()?.toInt()

    } catch (e: Exception) {
        e.printStackTrace()//this will print system race to system admin,not to user,so later we can use this to fix this issue

        println("An exception happened! \n ${e.localizedMessage}")
    } finally {
        println("end of execution")//this line of code will be executed whether or not exception occurs
    }
}

fun tryCatchWithoutFinally() {
    println("enter number:")
    try {
        val enteredInput = readLine()?.toInt()

        println("end of execution")//this line of code will be executed only if there is no exception
    } catch (e: Exception) {
        e.printStackTrace()//this will print system race to system admin,not to user,so later we can use this to fix this issue

        println("An exception happened! \n ${e.localizedMessage}")
    }
}
