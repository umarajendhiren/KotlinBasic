package com.androidapps.basic.kotlinbasics

var name="uma"

fun main() {

    //we no need to do null check here because by default everything is non null in kotlin
    println(name.length)

    //we will get compile time error if we try to set null value to non null type string
   // name=null

    //if we really wants to set null value for our variable ,we need to add ? after variable type string

    var lastName:String? = "Rajendhiren"
    lastName=null


    //now if we try to call length method on lastname ,it will give compile time error ,use safe call operator ?. or non null assertion !!
    //println(lastName.length)

     //first method
    //safe call operator  ?.
    lastName="raj"
    println( "legth of raj is ${lastName?.length}")//if name is not null it will call length method else it will display null as result

    lastName=null
    println( "legth of null is ${lastName?.length}") //it will print " legth of null is null"



    //second method
    //if we want to print some value if name  is null, we need to use elvis operator

    val l= lastName?.length ?: "name is null And length is zero"
    println(l)

    val len= lastName?.length ?: -1
    println(len)




    //third method ,if we really wants to introduce NPE
    //non null assertion

    lastName="raj"
    println(" lenght of raj is ${lastName!!.length}") //if lastname is not null it will call length else crash for null value throws null pointer exception

    lastName=null
    //println(" lenght of raj is ${lastName!!.length}")

}