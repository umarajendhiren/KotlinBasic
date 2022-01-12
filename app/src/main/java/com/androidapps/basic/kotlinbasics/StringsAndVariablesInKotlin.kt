package com.androidapps.basic.kotlinbasics

/*string is a chain of zero or more characters surrounded by double quotes
* String contain any letter ,number character or symbol except double quotes" and backslash\
* because \ is escape character
* if string contains double quotes ,they need to be escaped
* A character is escaped with backslash\ .that's why \ not allowed  in string .
* empty string is also allowed */

fun main() {
    println("This message contain \"double\" quotes")

    /*if we put double back slash it will interpreted as single back slash*/
    println("This contain double back slash \\")

    /*A Char is a single character
    * Char is surrounded by single quotes
    * String is composed of characters
    * String is surrounded by double quotes*/

    println('A')
    println("A")

    /*Variable is like container for data ,we can assign and reassign it later
    * variable name has to give some information to reader about the variable
    * variables name can contain letters ,numbers,underscore _
    * it can not contain spaces ,because spaces are delimiter
    * variable name must start with a letter or an underscore
    * variable name can be anything except kotlin keyword.
    *like we can not use variable name "is" or "var" because  "is" and "var" is a kotlin keyword.
    * Naming convention -camelCase -"myDogFunny"*/
    var name = "uma"
    name = "karthika"
    println(name)

    var nameWithoutSpace = "MyName"
    // var nameWith  space="suekfh" //will get error

    /*we can not change variable's type*/
    var age = 32
    // age="thirty two"  //type mismatch error

    /*var is mutable(changeable)
    * val is immutable (read only)
     */
    val id = 7
    // id=9 //will get error:id can not be reassigned


    /*example*/
    val dogName = "my dog's name is \"fluffy\""
    println("dog name is $dogName")

    var typesOfbackSlash = "two types of slash \\ and /"
    println("typesOfbackSlash:$typesOfbackSlash")

    var googleHomePage="http://www.google.com"
    println("googleHomePage is $googleHomePage")
}