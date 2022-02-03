package com.androidapps.basic.kotlinbasics

import kotlin.random.Random

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

fun withFunction() {
    /*it is similar to let function like perform a block of code on an object
    * the context available as 'this'.this keyword can be omitted.
    * can access variable and methods inside this function
    * typical use case:
    * perform some initialization on an object
    * perform a sequence of action on an object*/

    with(Car3()) {
        speed = 80
        drive()
    }

    /*here we can avoid object.shoes,object.shirts call using 'with' function */
    with(Store()) {
        shoes = 40
        shirts = 50
        jackets = 60
        availableStock()
    }

}

fun runFunction() {
    /*same as with but invokes as an extension function
    * this is useful when we need a lambda that returns a result
    * can be used to limit the scope of variables*/

    var newCar = Car3().run {
        speed = 190
        drive()
        this
        // run function return last statement in this block.'this' returns an object .if we comment it,it will return Unit.(kotlin.Unit)
    }
    println(newCar)

    /*another way to call run
    * car object only available within run bock ,after this execution of run ,car object will be discarded */
    /* run{
         var car=Car3()
         car.speed=120
         car.drive()
     }

     println(car)  //not available
     */




    Laptop2().run {
        turnOff()
        turnOn()
    }
}


fun applyFunction() {
    /* can be used to apply some functionality and return a result
    * returns the  initial object
    * common use case is applying configuration to an object creation*/

    var car = Car3().apply {
        speed = 200
        drive()
        //here we no need to return 'this' like 'run' function .'apply' function return object by default
    }
    println(car)
}


fun alsoFunction() {
    /*used for performing some additional action on an object
    * common use case is adding some actions that don't affect the object such as logging or debugging information
    * removing an  'also' block should not affect the execution of program*/

    Car3().apply {
        speed = 200
        drive()
    }.also { println("car has been started") }//for debugging purpose


/*Exercise: Also

Whenever a car is built, the company logs must be updated and the police notified.

Implement this functionality in a program.*/

    Car3().apply {
        speed = 210
        drive()
    }.also {
        println("building car $it")
        println("sending message to police that $it car has been built ")
    }//for debugging purpose


}

fun takeIf() {
    /*returns the  object if the predicate value to true
    * otherwise it returns null  */

    for (i in 1..10) {
        var number = Random.nextInt(100)
        var evenOrNull = number.takeIf { it % 2 == 0 }
        println("the number is $number")
        println("even number is $evenOrNull")
    }


}

fun takeIf1() {
    /*You have a list of numbers.
      Using the take functions, print out a list that contains only the even numbers.
*/
    var listOfNumbers = listOf(1, 324, 6, 23, 2, 5, 46, 65, 7, 84, 56)
    var evenNumbersResult = arrayListOf<Int>()
    listOfNumbers.forEach {
        it.takeIf { it % 2 == 0 }
            ?.let { evenNumbersResult.add(it) }  //if not null add to list
    }
    println(evenNumbersResult)
}


fun takeUnless() {
    /*returns the  object if the predicate value to false
    * otherwise it returns null  */

    for (i in 1..10) {
        var number = Random.nextInt(100)
        var oddOrNull = number.takeUnless { it % 2 == 0 }
        println("the number is $number")
        println("odd number is $oddOrNull")
    }


}


fun takeUnless1() {
    /*You have a list of client names.
    Using the take functions, print out a new list of client names that don’t start with the letter ‘A’.

*/
    var cleintNames = listOf("Fdgfg", "AdFdf", "Dfgf")
    var nameNotStartWithA = arrayListOf<String>()
    for (cleintName in cleintNames) {
        cleintName.takeUnless { it[0] == 'A' }?.let { nameNotStartWithA.add(it) }
    }
    println(nameNotStartWithA)
}


fun takeIfTakeUnless() {
    /*Exercise: takeIf and takeUnless

Have the user introduce 10 numbers.

Print a list that contains only odd numbers and make sure to exclude the numbers 3 and 13.*/


    var numbers = listOf(1, 2, 3, 4, 5, 23, 15, 13)
    var resultList = arrayListOf<Int>()
    for (number in numbers) {
        number.takeUnless { it % 2 == 0 }  //return odd number  or if it is even return null
            // ?.takeIf { it % 2 != 0 }  //takeIf can also be used  to filter odd
            ?.takeUnless { it == 3 || it == 13 }  //if above condition is not null returns number if it is not 3 or 13
            ?.let { resultList.add(it) }
    }
    println(numbers)
    println(resultList)
}

fun main() {
    //letStandardFunction()
    //letExample1()
    //letExample2()
    //letExample3()

    //withFunction()

    //runFunction()

    //applyFunction()
    /*  println("enter client name")
      var enteredName = readLine() ?: ""
      var coffeeShop = CoffeeShop1(enteredName)
      coffeeShop.sellCoffee()*/

    // alsoFunction()

    //takeIf()
    //takeIf1()

    //takeUnless()
    // takeUnless1()

    takeIfTakeUnless()

}

class Car3 {
    var speed = 30
    fun drive() {
        println("driving at speed $speed")
    }
}

/*with example:
A store has a supply of shoes, shirts and jackets, as well as a method to print out the inventory.
Create a variable of type store, update its stock and print out the inventory.*/
class Store {
    var shoes = 10
    var shirts = 20
    var jackets = 30
    fun availableStock() {
        println("$shoes shoes, $shirts shirts, $jackets jackets available")
    }

}


/*Exercise: Run

A laptop has two functions, turnOn and turnOff.

To make sure it works as expected, every time we have a new laptop object, the protocol is to turn it off and then back on again.

Create a laptop object and implement the protocol.


*/

class Laptop2 {
    fun turnOff() {
        println("turning off")
    }

    fun turnOn() {
        println("turning on")
    }
}


/*Exercise: Apply

A coffee shop serves cups of coffee.
A cup of coffee has a client name and a method for preparing the coffee.

Read a client name from the console, then call the sellCoffee method of the coffee shop.
Create a coffee cup object, initialise it and serve it to the client.*/

class CoffeeCup {
    var clientName = ""
    fun prepareCoffee() {
        println("preparing coffee for $clientName")
    }
}

class CoffeeShop1(var cleint: String) {


    fun sellCoffee() {
        var coffeeCup = CoffeeCup().apply {

            clientName = cleint
            prepareCoffee()
            println(this)
        }

        println(coffeeCup)
    }

}





