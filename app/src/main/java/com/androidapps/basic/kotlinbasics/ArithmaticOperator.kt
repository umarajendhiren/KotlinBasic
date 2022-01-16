package com.androidapps.basic.kotlinbasics

fun main(){

    println("Addition:${1+1}")
    println("concatenation :"+"hi "+"there")

    println("subtraction:${5-1}")

    println("multiplication:${2*3}")

    println("division:${5/2}") //gives int value

    println("division float:${5/2f}") //gives float value

    println("modulus:${5%2}") //gives reminder

    //increment operator

    var dog=3

    println("i have ${dog++} dogs")//first use value then increment(3)
    println("i have ${dog} dogs")//first use value then increment(4)

    dog=3
    println("i have ${++dog} dogs") //first increment value then use it(4)

    println("i have ${dog--} dogs")  //4
    println("i have ${--dog} dogs")   //2


}