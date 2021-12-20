package com.androidapps.basic.kotlinbasics

class ReturnsAndJumps

fun main() {


    /*Kotlin has three structural jump expressions:

return by default returns from the nearest enclosing function or anonymous function.

break terminates the nearest enclosing loop.

continue proceeds to the next step of the nearest enclosing loop.*/
    breakAndContinue();

    returnWithoutLable()
    labledreturn()
}


fun returnWithoutLable() {

    /*return -by default non-labeled returns statements return from the nearest (i.e. innermost) enclosing fun (ignoring lambdas).

    non-labeled  return  finish the execution of this whole function not just the  lambda function */
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 5) return // this return  finish the execution of this whole function not just the  lambda function
        print(it)
    }
    println("this point is unreachable")
}

fun labledreturn() {

    /*if you want to return from any other function (a lambda or an outer fun) you have to specify it as a label at return statement
    this labeled return, finish just lambda not whole function
    * important use case is  returning from a lambda expression.
    * in java it is not possible*/
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print(" done with explicit label")
}

fun breakAndContinue() {

    /*by default non-labeled break terminates the nearest enclosing loop
    *if we want to terminate  from  outer loop we need to use labeled break statement
    * in java it is not possible */
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j === 3) {
                println("going to break loop at value $j");
                break@loop
            }
        }
    }
}
