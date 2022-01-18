package com.androidapps.basic.kotlinbasics

fun main() {

    //arithmeticOperator()

    //resultType()

    augmentedAssignmentOperator()

}

fun augmentedAssignmentOperator() {


    var bikes=5

    bikes+1  //added 1 but did not  assign to bike
    println(bikes)//will get 5

    bikes+=2 //added and assigned
    println(bikes)//will get 7

    bikes-=1
    println(bikes)//will get 6

    bikes*=2
    println(bikes)//will get 12

    bikes/=2
    println(bikes)//will get 6

    bikes%=2
    println(bikes)//will get 0
}

fun resultType() {
    //Byte<Short<Int<Long<Float<Double

    /*   var a:Int=2
       var b:Short=3
       var result1=b/a
       println("result1 type is ${result1::class.java}")    //int*/

    /*     var a:Int=2
      var b:Long=3
      var result1=b/a
      println("result1 type is ${result1::class.java}")   //long
  */


/*
       var a:Long=2L
    var b:Float=3F*/

    /* var a = 2L
     var b = 3F
     var result1 = b / a
     println("result1 type is ${result1::class.java}") //float*/


    var a: Double = 2093583.485043
    var b = 31.3F
    var result1 = b / a
    println("result1 type is ${result1::class.java}") //double


}

fun arithmeticOperator() {
    println("Addition:${1 + 1}")
    println("concatenation :" + "hi " + "there")

    println("subtraction:${5 - 1}")

    println("multiplication:${2 * 3}")

    println("division:${5 / 2}") //gives int value

    println("division float:${5 / 2f}") //gives float value

    println("modulus:${5 % 2}") //gives reminder

    //increment operator

    var dog = 3

    println("i have ${dog++} dogs")//first use value then increment(3)
    println("i have ${dog} dogs")//first use value then increment(4)

    dog = 3
    println("i have ${++dog} dogs") //first increment value then use it(4)

    println("i have ${dog--} dogs")  //4
    println("i have ${--dog} dogs")   //2

}
