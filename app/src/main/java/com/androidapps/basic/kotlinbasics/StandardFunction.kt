package com.androidapps.basic.kotlinbasics

/*standard Functions are functions that we can apply for an object
also called scope functions
execute the code in the context(scope) of an object
the way the standard function works that they create temporary scope while the code is executed.in that scope, we can access the original object

5 Scope functions:
* let
* with
* run
* apply
* also

2 check functions:

* takeIf and takeUnless*/


/*let function allow us to run code on an object or run code on result of function
we can access the result as a lambda argument(it by default)
let function execute block of codes ,if object is not null
* it keyword  refers to the object on which we apply let function  */
fun letStandardFunction() {
    var listOfAnimals = listOf("dog", "cat", "bear", "lion")
        .map { it.length } //creates list of length
        .filter { it > 3 }  // returns filtered list
        /*.let {
            println(it)  //prints filtered list
            println("size of filtered list is ${it.size}")
        }*/

        .let { filteredList -> println(filteredList) }


    /*if the let block contains single method call we can use the method reference :: */

    var listOfAnimals1 = listOf("dog", "cat", "bear", "lion")
        .map { it.length } //creates list of length
        .filter { it > 3 }  // returns filtered list
        .let(::println)

    println("enter your name")
    var name = readLine()
    name?.let { println("Hello $it") }  //let uses object only if object is not null .if it is null it only prints hello
}

fun letExample1() {
    /*Read a text from the console.
    If it’s not null, convert it to an Int, double it and print it to the console.
*/
    println("enter number")
    var enteredNumber = readLine()?.toInt().let {
        println("double of $it is ${it?.times(2)} ")
    }
}

fun letExample2() {
    /*Read 3 animals from the console and add them to a list. If you read an empty string, add a null to the list.
For each animal in the list, print a ‘feeding the animal’ message.
*/
    var listOfAnimals = arrayListOf<String?>()

    for (i in 1..3) {
        println("enter an animal")
        var enteredName = readLine()

        /*another way*/
        /*  if (enteredName == "")
              listOfAnimals.add(null)
          else listOfAnimals.add(enteredName)*/

        enteredName?.let {
            if (it == "")
                listOfAnimals.add(null)
            else listOfAnimals.add(it)
        }


    }

    listOfAnimals.forEach {
        it?.let { println("feeding the $it") }  //filtering out null element
    }
}

fun letExample3() {
    /*Read client names from the console until the word stop is introduced.
     If the string is empty, the client is null.
    Print out a hello message for each client.*/
    var listOfWord = arrayListOf<String?>()
    var isWordStop = false
    do {
        println("enter word")
        var enteredWord = readLine()
        enteredWord?.let {
            if (it == "")
                listOfWord.add(null)
            else {
                if (it.lowercase() == "stop")
                    isWordStop = true
                else
                    listOfWord.add(it)
            }
        }
    } while ((!isWordStop))

    listOfWord.forEach {
        it?.let { println("hello $it!") }
    }
}

fun main() {
    //letStandardFunction()
    //letExample1()
    //letExample2()
    letExample3()
}