package com.androidapps.basic.kotlinbasics

class ContainerTruck {
    var name = ""

    var speed: Int
        get() = 50
        set(vale) {
            name = "Speed of High Speed Truck is $vale"
        }

}


/*A bank has various rules for interest rates.

If a user has less than 1000 in their account, their interest rate is 1.0

If a user has less than 10000 in their account, their interest rate is 0.5

If a user has 10000 and over, their interest rate is 0.2.

Implement this in a program, create an object, update the amount and print out the interest rate.*/

class BankAccount() {
    var interestRate = 0.0
    var amount: Int = 0
        get() = field
        set(value) {
            if (value < 1000)
                interestRate = 1.0
            else if (value < 10000)
                interestRate = 0.5
            else interestRate = 0.2
            field = value

            println("the user has $amount and has an interest $interestRate")
        }

}


class ThisExample() {
    /*this refers to parameter of the class*/
    var message = "No message"
    fun updateMessage(message: String) {

        /*this.message refers class variable message
        * message refers to function parameter message*/
        this.message = message
    }
}


fun main() {
    var truck = ContainerTruck()
    truck.speed = 1000  //will use set()
    println(truck.name)
    println(truck.speed)  //will use get()

    var bankAccount = BankAccount()
    bankAccount.amount = 1001

    var thisExample = ThisExample()
    println(thisExample.message)
    thisExample.updateMessage("Updated message")
    println(thisExample.message)
}