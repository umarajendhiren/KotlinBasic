package com.androidapps.basic.kotlinbasics

import kotlin.random.Random

const val URL = "google.com"
fun main() {

    /*length of string.
    * here length is property of string */
    var petName = "crocodile"
    println(petName.length)

    /*makes the first character as capital in a given string
    * this method is deprecated and need to use replaceFirstCharacter()
    * */
    var name = "ashok"
    println(name.capitalize())

    name = name.replaceFirstChar { it.uppercase() }
    println(name)


    var _name = "Ashok"
    println(_name.decapitalize())

    _name = _name.replaceFirstChar { it.lowercase() }
    println(_name)


    val sentence = "Welcome to Kotlin!"
    var words = sentence.split(' ');
    println(words.joinToString(separator = "-") { it.lowercase() })

    var StringWithSpace = "   String    has more Space     "
    println(StringWithSpace.trim())

    //get the char at 3rd index place
    println(petName.get(3))

    //another way to get char at index
    println(petName[3])

    /*Returns a substring of this string that starts at the specified startIndex and continues to the end of the string*/
    println(petName.substring(3))

    /*Returns the substring of this string starting at the startIndex and ending right before the endIndex
    * 6th index not included*/
    println(petName.substring(3, 6))


    /*String template:
    * string in kotlin can contain expression
    * expression is evaluated and inserted (concatenated) into string
    * we can insert variable into a string using expression
    * expression starts with $ sign and can have braces*/

    //variable template
    var dogName = "Teddy"
    println("my dog name is $dogName")

    //expression template
    println("i have ${1 + 1} dog")


    /*constants:
    * are another way to define variable
    * value of constants do not change
    * they are available at compile time and they are not calculated at runtime
    * they can be declared Top level which means we can declare outside of the function or class
    * convention :names are in all-caps */
    println("google url is \"$URL\"")


    // getUserInput()

    //getNumberInput()

    ageCalculator()

    //genarateRandomNumber()

}

fun ageCalculator() {
    println("enter your birth year:")

    val birthYearString= readLine()?:""
    val birthYearInt=birthYearString.toInt()
    val age=2022-birthYearInt

    println("your age is either ${age-1} or $age")
}

fun genarateRandomNumber() {
   println("random int number:${Random.nextInt()}")
   println("random int number until 100 is :${Random.nextInt(100)}")  //100 not included
   println("random int number from 1 to 50 is :${Random.nextInt(1,50)}")  //50 not included

   println("random double number until 50 is :${Random.nextDouble(50.0)}")
}

fun getNumberInput() {
    /*number input*/
    println("enter number:")

    val number = readLine()?:""  //this method always  returns string ,may null
    val numberToInt = number.toInt()

    println("entered number is $numberToInt")
}

fun getUserInput() {
    /*input from user*/
    println("enter your input:")
    var userInput = readLine() //this method read only one line of input and may returns null
    println("entered input is $userInput and length is ${userInput?.length ?: -1}")

}
