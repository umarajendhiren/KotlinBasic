package com.androidapps.basic.kotlinbasics

val fruitList= listOf("Apple","Banana") //immutable
val fruitListArrayList= arrayListOf("Apple","Banana") //mutable
val systemUsers= mutableListOf(1, 2, 3)//mutable


val fruitListMutable:MutableList<String> =mutableListOf("Apple","Banana") //mutable
val readOnly: List<String> = fruitListMutable //immutable read only list


val unOrderedSet= setOf("one","two") //immutable set
val unOrderedSetMutable= mutableSetOf("one","two") //immutable set




val myMap= mapOf("one" to "item1","two" to "item2")
val myMapMutable= mutableMapOf("one" to "item1","two" to "item2")





fun main() {


    fruitListArrayList.add("orange")
    println(fruitListArrayList)

    fruitListMutable.add("pineapple");
    println(fruitListMutable)

   // readOnly.add() ->will throw error

    unOrderedSetMutable.add("three")
    println(unOrderedSetMutable)
   // unOrderedSet.add()->will throw error

    println(unOrderedSetMutable.add("three"))//return false because duplicate not aloud


   // myMap= mapOf("one" to "item1","two" to "item2")  //can not reassign

    //myMapMutable= mutableMapOf("one" to "item1","two" to "item2")

}

