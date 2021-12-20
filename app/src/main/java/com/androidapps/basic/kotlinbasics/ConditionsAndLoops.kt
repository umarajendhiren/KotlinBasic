package com.androidapps.basic.kotlinbasics


fun main() {


    // ifExpression();

    //whenExpression();

   /* println(whenAsExpression("Hello"))
    println(whenAsExpression(3.4))
    println(whenAsExpression(1))
    println(whenAsExpression(KotlinBasic()))*/

  /*  whenAsStatement("Hello")
    whenAsStatement(1)
    whenAsStatement(0L)
    whenAsStatement(KotlinBasic())
    whenAsStatement("hello")*/

   // isStringOrInt("uma")
    //isStringOrInt(1)

   // forLoopRangeExpression()

    whileAndDoWhile()

}

fun whileAndDoWhile() {
   /*while and do-while loops execute their body continuously while their condition is satisfied.

     while checks the condition and, if it's satisfied, executes the body and then returns to the condition check.

     do-while executes the body and then checks the condition. If it's satisfied, the loop repeats.
     So, the body of do-while executes at least once regardless of the condition.*/

    fun eatACake() = println("Eat a Cake")
    fun bakeACake() = println("Bake a Cake")

    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {                    // 1
        eatACake()
        cakesEaten ++
    }

    do {                                        // 2
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}

fun forLoopRangeExpression() {
    /*for loop is used to iterate through the element in collection.
    */

    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {                               // 1
        println("Yummy, it's a $cake cake!")
    }


/*If you want to iterate through an array or a list with an index, you can do it this way:*/
        val array = arrayOf("a", "b", "c")
        for (i in array.indices) {
            println(array[i])
        }

    /*Alternatively, you can use the withIndex library function:*/

    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }

  /*  To iterate over a range of numbers, we can use a range expression*/


    for(i in 0..3) {             // Iterates over a range starting from 0 up to 3 (inclusive)  Like 'for(i=0; i<=3; ++i)
        print(i)
    }
    print(" ")

    for(i in 0 until 3) {        // Iterates over a range starting from 0 up to 3 (exclusive). like 'for(i=0; i<3; ++i)
        print(i)
    }
    print(" ")

    for(i in 2..8 step 2) {      // Iterates over a range with a custom increment step for consecutive elements.
        print(i)
    }
    print(" ")

    for (i in 3 downTo 0) {      // Iterates over a range in reverse order
        print(i)
    }
    print(" ")



    /*Char ranges are also supported:*/

    for (c in 'a'..'d') {        // 1
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 's' step 2) { // 2
        print(c)
    }
    println()


    /*Ranges are also useful in if statements:*/

    val x = 2
    if (x in 1..5) {            // 1
        print("x is in range from 1 to 5")
    }
    println()

    if (x !in 6..10) {          // 2
        print("x is not in range from 6 to 10")
    }
}



    fun whenExpression() {
    /*when is a conditional expression  with multiple branches.
    * it similar to switch statement in java
    * we can use "when"as a statement or an expression
    *  when  will be executed until some branch condition is satisfied
    *
    *  If it is used as an expression, the value of the first matching branch becomes the value of the overall expression
    *  If when is used as an expression, the else branch is mandatory
    *
    * If it is used as a statement, the values of individual branches are ignored
    *
    *  Just like with if, each branch can be a block, and its value is the value of the last expression in the block. */
    var x = 1;
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")

        }
    }

    println()

    x = 3;
    val y = when (x) {
        1 -> {
            print("x == 1")
            "one"
        }
        2 -> {
            print("x == 2")
            " two"

        }
        else -> {
            print("x is neither 1 nor 2")
            " not one or 2"
        }
    }

    println()
    println("y value is $y")


    println()
    /*we can combine the condition in one line  with a comma */

    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }


    println()

    /*You can also check a value for being in or !in a range or a collection:*/
    x = 21
    when (x) {
        in 1..10 -> print("x is in the range")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }


}

fun whenAsExpression(obj: Any): Any {
    val result = when (obj) {                   // This is a when expression
        1 -> "one"                              // Sets the value to "one" if obj equals to one..
        "Hello" -> 1                            // Sets the value to one if obj equals to Hello
        is Long -> false                        // Sets the value to false if obj is an instance of Long
        else -> 42                              // Sets the value "42" if none of the previous conditions are satisfied. Unlike in when statement, the default branch is usually required in when expression, except the case when the compiler can check that other branches cover all possible cases.
    }
    return result
}

fun whenAsStatement(obj: Any) {
    when (obj) {                                     // This is a when statement
        1 -> println("One")                          // Checks whether obj equals to one.
        "Hello" -> println("Greeting")               // Checks whether obj equals to Hello
        is Long -> println("Long")                   // Performs type checking
        !is String -> println("Not a string")        // Performs inverse type checking
        else -> println("Unknown")                   // Default statement (might be omitted).
    }
}


/*we can use is and !is operator with in when statement*/

    fun isStringOrInt(x: Any) =
        when (x) {

            is String -> println("string length is ${x.length}")

            is Int -> println("after subtract 2 from x is  ${x.minus(2)}")


            else -> println("x is neither string nor integer")

        }


    fun ifExpression() {

        /*
    * in kotlin ,if is an expression and returns a value
    * if branches can be code block ,in that case ,last expression  is the value of a block
    * if ,if branch returns value or assigning it to a variable ,the else branch is mandatory */

        val a = 1;
        val b = 2;

        val max = if (b > a) b else a

        println("maximum is $max")


        val maxi = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }

        println()
        println("maximum in code block is $maxi")

    }



class KotlinBasic