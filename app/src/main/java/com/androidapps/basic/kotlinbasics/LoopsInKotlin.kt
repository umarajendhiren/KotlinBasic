package com.androidapps.basic.kotlinbasics

var myList= listOf("item1","item2","item3")

var myMapp= mapOf("one" to "item1","two" to "item2")

var i=10

fun main() {
    for( list in myList ){
     println(list)
    }

    for((key,value) in myMapp){

        println("key is $key and value is $value")

    }


    while (i>=0){

        println(i)
        i--

    }

}
