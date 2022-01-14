package com.androidapps.basic.kotlinbasics

fun main() {
    /*Byte (8bit) -128 to 128
    *Short (16bit) -32768 t0 32767
    * Int (32bit) -2^31 to (2^31)-1
    *Long (64 bit) -2^64 to (2^64)-1
    *
    * Float (32bit) 6 to 7 decimal digits
    * Double (64bit) 15-16 decimal digits*/

    //findVariableType()

    //askFromUser()

    typeConversion()
}

fun typeConversion() {

    /*A variable can be converted into another type and result can be assigned to another variable ,not variable itself
    * here we are doing upcasting(int to long)*/
    var cat = 3 //int
    var longCat = cat.toLong()  //long

    // cat=cat.toLong()//not allowed ,type mismatch


    /*if we do downcast(long to int ,smaller type ) ,if the long number fit into int there is no loss  of information.
    * if the long number doesn't fit into int ,the information lose may occur (data corruption)*/


    val population = 75000000000//long

    val fewPopulation = population.toInt()

    println("population type is ${population::class.java}")
    println("fewPopulation type is ${fewPopulation::class.java}")

    println("population is:$population")
    println("fewPopulation is:$fewPopulation")


    /*any variable can be converted into string */

    var stringForm = population.toString()
    println("string form of population:$stringForm and type is ${stringForm::class.java}")

    var pi = 3.1415916
    var piToString = pi.toString()
    println("string form of pi:$piToString and type is ${pi::class.java}")

}

fun findVariableType() {
    var item = 5  //int  when we declare this variable ,kotlin automatically assign type for it
    var numberOfPeople = 75000000000000  //Long
    var price =
        29.99    // double ,this one fit into float but kotlin system decides double to store this variable
    var pi = 3.1415916     //double(more than 7 bit)

    println("item type is :${item::class.java}")  //this will print out type of variable
    println("numberOfPeople type is :${numberOfPeople::class.java}")  //this will print out type of variable
    println("price type is :${price::class.java}")  //this will print out type of variable
    println("pi type is :${pi::class.java}")  //this will print out type of variable

}

fun askFromUser() {
    println("enter number to know its type")
    var enteredNumber = readLine()?.toInt()
    var pi = 3.14

    var finalValue = enteredNumber?.times(pi)
    println("your number * pi is:$finalValue")
    println("type is : ${finalValue!!::class.java}")

}
