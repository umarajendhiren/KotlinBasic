package com.androidapps.basic.kotlinbasics

var name = "uma"


/*if we try to call some function on null value we will get null pointer exception resulting App will crash
* for instance if string "name" is null ,if i try to call length of name ,we will get NPE because name is null
* if i set on click listener on button ,without initiating button ,we will get NPE.
* this is main drawback when we write program in java .we need to handle everything related to NPE
* kotlin has a tool to avoid null pointer exception.that is key selling point of kotlin over java */
fun main() {


    var catName: String?  //nullable
    //println(catName)  //before use nullable variable ,need to initiate that variable.
    catName = "myCatName"
    println(catName)
    catName = null //can be null

    var dogName = "myDogName"
    println(dogName)
    //dogName=null //compilation error:null can not be a value of non null type string


    //this will always return length of name since name is certainly not null .we no need to do null check here because by default everything is non null in kotlin
    println(name.length)

    //we will get compile time error if we try to set null value to non null type string
    // name=null

    //if we really wants to set null value for our variable ,we need to add ? after variable type string

    var lastName: String? = "Rajendhiren"
    lastName = null


    //now if we try to call length method on lastname ,it will give compile time error ,use safe call operator ?. or non null assertion !!
    //println(lastName.length)

    //first method
    //safe call operator  ?.
    lastName = "raj"
    println("legth of raj is ${lastName?.length}")//if name is not null it will call length method else it will display null as result

    lastName = null
    println("legth of null is ${lastName?.length}") //it will print " legth of null is null"

    /*safe calls call can be chained for multiple operations*/
    lastName = "rajendhiren"
    println("string value of length of non null is ${lastName?.length?.toString()}")

    lastName = null
    println("string value of length of null is ${lastName?.length?.toString()}")

    //second method
    //if we want to print some value if name  is null, we need to use elvis operator

    val l = lastName?.length ?: "name is null And length is zero"
    println(l)

    val len = lastName?.length ?: -1
    println(len)


    //third method ,if we really wants to introduce NPE
    //non null assertion
    //this operator is risky one .we need to avoid as much as we can

    lastName = "raj"
    println(" length of raj is ${lastName!!.length}") //if lastname is not null it will call length else crash for null value throws null pointer exception

    lastName = null
    //  println(" length of raj is ${lastName!!.length}")


    /*Arithmetic operator only works on non null variable.we can not use Arithmetic operator if we wants to do arithmetic operation  on null variable
    * replacement methods are available for null variable
    * + > ?.plus()
    * - > ?.minus()
    * * > ?.times()
    * / > ?.div()
    * % > .?rem() */

    var a: Int? = 10

    println("Addition is:${a?.plus(3)}")
    println("subtraction is:${a?.minus(3)}")
    println("multiplication is:${a?.times(3)}")
    println("divided by 3 is:${a?.div(3)}")
    println("reminder is:${a?.rem(3)}")


    /*substring of nullable string*/
    val greeting: String? = "HelloKotlin!"
    println(greeting?.substring(3, 6))  //lok

    var doubleValue: Double? = 12.22
    println("double to float is ${doubleValue?.times(6)?.toFloat()}")


    println("enter something:")
    var lengthOfName = readLine()
    println(lengthOfName?.length)


    /*read number from console and convert it to double
    * multiply by 7 and convert result to string
    * print length of string */
    println("enter number:")
    var enteredNumber = readLine()?.toInt()
    println(enteredNumber?.times(7).toString().length)

/*A product cost is 29.99
* ask user at console ,how many products they wants to buy
* if read value is null ,use default one
* print total of purchase*/

    var productCost=29.99
    println("How many products would you like to buy ?")
    var purchasedProducts= readLine()?.toInt()?:3

    println("total is${purchasedProducts.times(productCost)}")

}