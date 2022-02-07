package com.androidapps.basic.kotlinbasics

import java.util.*
import kotlin.random.Random

/*is
* 'is' operator check whether the object is of a certain type
* the opposite operator is '!is'*/

/*as:
* 'as' operator allow us to converts an object into a different type
* 'as?' null safe operator:if not convert object type into different type otherwise it is null*/



fun isOperator() {
    var myString = "fgnfdj"
    if (myString is String)
        println("${myString.length} characters")


}

open class Car5 {}
class BMW2 : Car5() {
    fun drive() {
        println("driving BMW")
    }
}

//fun getCar() = Car5()
fun getCar() = BMW2()

fun notIsOperator() {

    val myCar: Car5 = getCar()
    if (myCar !is BMW2)
        println("this is not my favorite")

    /*   fun getCar() = BMW()
       val myCar: Car4 = getCar()
        if (getCar() is BMW) {
            println("BMW is my favorite")
        }*/


}

fun asOperator() {
    val myCar: Car5 = getCar() //returns BMW() .if returns Car5() drive method won't run
    if (myCar is BMW2)  //at this moment, myCar is of type Car5
        (myCar as BMW2).drive()  //now i can invoke BMW function(drive) on myCar(type conversion)


}

fun nullSafeOperator() {
    val myCar: Car5 = getCar()  //returns BMW2()
    val myBMW: BMW? =
        myCar as? BMW //if myCar Not BMW type it will convert into BMW type when it is convertible
    myBMW?.drive()
}


/*lateinit:
*allow us to create non null ,non initialized variables
* we need to initiate non null variable right away  when we declare it .else we get(Property must be initialized or be abstract)
* otherwise we need to declare it as nullable when we don't want to initiate
* but if we want to declare non null as well as we don't want to initiate when we declare,in that situation we can use lateinit
* need to initialize lateinit variable before using it
* Accessing it before initializing it  throws an exception
* can be used only on 'var' variables
* wa can use .isInitialized() to check initialization
* common Use cases:
* dependency injection
* unit testing    */

lateinit var networkService: String;
fun getNetworkService1() = "Network service"

fun lateinitExample() {

    networkService = getNetworkService1()
    println(networkService)

}

/*A class country has a private variable name, a function that initializes that variable and a function that returns the non null country name.
In your main program, initialize an object of the class Country and print out a message for that country name. *
*/
class Country {
    private lateinit var name: String
    fun setName(name: String) {
        this.name = name
    }

    fun getName() = name
}

/*lazy keyword:
* we use this lazy variable for memory optimization
* this variable are initialized when needed
* useful to save memory in case the variable never used
* only used on 'val' variable  */
fun lazyVariableExample() {

    val someLargeVariable: String by lazy { "A large value" }
    for (i in 1..10) {
        val random = Random.nextInt(10)
        if (random % 2 == 0)
            println(someLargeVariable) //now only this variable created and used by system
    }
}

/*An object of a class NewUser is created for each new user. It contains a function to print a welcome message.

In your program, you have a list of banned usernames.

Ask the user to input their desired username. If it is not part of the list, create the NewUser object and print the welcome message.


*/
class NewUser() {
    fun welcomeMessage(userName: String) {
        println("Welcome $userName")
    }
}

fun main(args: Array<String>) {
    //isOperator()
    // notIsOperator()

    //asOperator()
    //nullSafeOperator()

    //exampleForTypeCasting()
    // exampleForTypeCasting1()

    //lateinitExample()

    /*var country = Country().apply { setName("India") }
    println("country name is ${country.getName()}")*/

    //lazyVariableExample()

    val newUser by lazy { NewUser() }
    var bannedUser = listOf("Uma", "Kauthik")
    for (i in 1..5) {
        println("enter your name")
        var enteredName = readLine() ?: ""
        if (!bannedUser.contains(enteredName))
            newUser.welcomeMessage(enteredName)  //now only newUser instance will be created and used
        else println("You are banned!")
    }
}



/*An FTPService class inherits from the NetworkService class and ads a method transferFile().
A function returns a Network service.
In the main program, invoke the function and if the service is of type FTPService, call the transferFile() function
*/
open class NetworkService
class FTPService : NetworkService() {
    fun transferFile() {
        println("Transferring file via FTP..")
    }
}

//fun getNetworkService() = NetworkService()
fun getNetworkService(): NetworkService {
    var random = Random.nextInt(10)
    println("random number is $random ")
    return if (random % 2 == 0) {

        println("returning NetworkService")
        NetworkService()
    } else {
        println("returning FTPService")
        FTPService()
    }

}

fun exampleForTypeCasting() {


    for (i in 1..10) {

        var service = getNetworkService()
        (service as? FTPService)?.transferFile()
    }

}


/*Exercise: type casting

The classes Cat and Dog inherit from an abstract class Animal. The Cat class has a function purr() and the Dog class has a function bark()

A function provides a list of animals, that are randomly distributed.

Design a program that invokes each respective function of each type of Animal from the list.*/

open class Animal
class Cat : Animal() {
    fun purr() {
        println("Cat is Purring")
    }
}

class Dog1 : Animal() {
    fun bark() {
        println("Dog is barking")
    }
}

fun getAnimal(): Animal {
    var random = Random.nextInt(10)
    if (random % 2 == 0)
        return Cat()
    else return Dog1()
}

fun exampleForTypeCasting1() {
    for (i in 1..10) {
        var animal = getAnimal()
        (animal as? Cat)?.purr()
        (animal as? Dog1)?.bark()

    }
}
