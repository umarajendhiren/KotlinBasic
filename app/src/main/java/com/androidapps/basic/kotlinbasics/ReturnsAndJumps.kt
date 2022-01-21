package com.androidapps.basic.kotlinbasics

class ReturnsAndJumps

fun main() {


    /*Kotlin has three structural jump expressions:

return by default returns from the nearest enclosing function or anonymous function.

break terminates the nearest enclosing loop.

continue proceeds to the next step of the nearest enclosing loop.*/
    // breakAndContinue();

    // breakKeyword()
    // exerciseForBreak()

    // continueKeyword()
    exerciseForContinue()

    //returnWithoutLable()
    //labledreturn()
}

fun exerciseForContinue() {
    /*if name start with letter c ,should not say greetings else say greetings */
    var nameList = listOf("sd", "dsf", "ca", "afsd")
    for (name in nameList) {
        if (name[0] == 'c')
            continue
        println("Hai $name")
    }
}

fun exerciseForBreak() {

    var animalList = arrayListOf<String>()

    for (i in 1..5) { //ask users 5 times
        println("enter animal name:")
        var enteredName = readLine() ?: ""
        if (enteredName == "snake") {
            println("we won't accept snake.sorry!")
            break
        }
        animalList.add(enteredName)
        println("current animal is $animalList")

    }
}

fun breakKeyword() {
    /* in this example when the loop reaches 7, break will terminate the loop but importantly it won't print 8 and 10
    * so just skip current value and proceed to next value in loop we need to use continue keyword*/
    var onlyEvenNumbers = listOf(2, 4, 6, 7, 8, 10)
    for (number in onlyEvenNumbers) {
        if (number % 2 != 0)
            break
        println("Even number in list is $number")
    }

}

fun continueKeyword() {
/*simply skip current step and proceed to the next step of a loop
 */

    var onlyEvenNumbers = listOf(2, 4, 6, 7, 8, 10)
    for (number in onlyEvenNumbers) {
        if (number % 2 != 0)
            continue
        println("Even number in list is $number")
    }
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

    /*terminates a loop
    by default non-labeled break terminates the nearest enclosing loop
    *if we want to terminate  from  outer loop we need to use labeled break statement
    * in java it is not possible */
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 3) {
                println("going to break loop at value $j");
                break@loop
            }
        }
    }
}
