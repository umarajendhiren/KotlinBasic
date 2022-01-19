package com.androidapps.basic.kotlinbasics

import android.os.Build
import androidx.annotation.RequiresApi


/*collection:
* A way to group elements together
* can have zero or more element
* all elements inside collection is same type */


/*Iterator:
An Iterator is an object that loops through element of collection*/

val mutableHash = hashSetOf(1, 2, 2)
val myMap = mapOf("one" to "item1", "two" to "item2")
val myMapMutable = mutableMapOf("one" to "item1", "two" to "item2")


@RequiresApi(Build.VERSION_CODES.N)
fun main() {

    //listInKotlin()

    setInKotlin()
    getElementFromMutableSet()
    traversalThroughSetUsingIterator()
    cantainsAndContainsAll()
    checkingEqualityOfEmptySet()
    intersectingElement()
    clearHashSet()



    mapInKotlin()
    // myMap= mapOf("one" to "item1","two" to "item2")  //can not reassign

    //myMapMutable= mutableMapOf("one" to "item1","two" to "item2")

}


@RequiresApi(Build.VERSION_CODES.N)
fun mapInKotlin() {
    /*Map:
   * A set of key-value pairs
   * we can not have duplicate key .but values can be duplicate*/

    var pairMap = mapOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three"))  //immutable
    println(pairMap)

    /*if we create empty map we must specify the type*/
    val emptyMap = mapOf<Int, String>()

    /*get element using key (not an index)*/
    pairMap.get(1)
    println("value of key 1 is:${pairMap[1]}")

    /*keys in maps are Set (they are unique)
    * we can get whole set of keys at once*/
    println(pairMap.keys)

    /*values in maps are List.(can have duplicates)*/
    println(pairMap.values)


    /*add key-value pair to map*/
    val mutablePairMap = hashMapOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three"))  //mutable
    mutablePairMap.put(4, "four")
    println(mutablePairMap)

    val addMoreMap = mapOf(Pair(5, "five"), Pair(6, "six"))
    mutablePairMap.putAll(addMoreMap)
    println(mutablePairMap)

    /*we can remove element based on key not based on index*/
    mutablePairMap.remove(6)
    println("After removed six:$mutablePairMap")

    /*if we wants to replace the value for one specific key we can call replace*/

    mutablePairMap.replace(5,"replaced")
    println("After replaced:$mutablePairMap")

    /*we can remove all element using clear()*/
    mutablePairMap.clear()
    println(mutablePairMap)

    /*map functions:*/

   pairMap = mapOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three"))
    println("Size of immutable map:${pairMap.size}")
    println("Does the map have a key 3?${pairMap.containsKey(3)}") //true
    println("Does the map have a key 4?${pairMap.containsKey(4)}") //false

    println("Does the map have value \"one\"?${pairMap.containsValue("one")}") //true
    println("Does the map have value \"four\"?${pairMap.containsValue("four")}") //false

    println("is the map empty?${pairMap.isEmpty()}") //false
    println("is the map empty?${pairMap.isNotEmpty()}") //true


}

fun clearHashSet() {
    /*we can clear hashSet but can not clear Set because that is immutable*/
    val numbers = hashSetOf(1, 2, 3)
    println(numbers.clear())
    println(numbers)
}

fun intersectingElement() {
    val numbers = hashSetOf(1, 2, 3)
    val numbers1 = listOf(2, 3, 4)

    println(numbers.retainAll(numbers1))  //true

//number 2 is common element in both collection .mutable hashmap only holds intersecting element

    println("common element:$numbers")
}

fun getElementFromMutableSet() {
    /*get element at index 2*/
    println("The element at index 2 is: " + mutableHash.elementAt(2))

    /*no element at 10
    * throws IndexOutOfBoundsException: Collection doesn't contain element at index 10*/
    // println("The element at index 2 is: "+mutableHash.elementAt(10))


    println("The index of element 2 is: " + mutableHash.indexOf(2))

    /*not such element in set, will print -1 as index*/
    println("The index of element 6 is: " + mutableHash.indexOf(6))



    println("The last index of element 2 is: " + mutableHash.lastIndexOf(2))

    /*We can get the first and element of a set using first() and last() functions. */
    println("first element in mutableSet:" + mutableHash.first())
    println("last element in mutableSet:" + mutableHash.last())

}

fun traversalThroughSetUsingIterator() {
    val mutableHash = hashSetOf(1, 2, 2)
    //traversal of set using an iterator 'item'
    for (item in mutableHash)
        println(item)
}

fun cantainsAndContainsAll() {

    val captains = mutableSetOf(
        1, 2, 3, 4, "Kohli", "Smith",
        "Root", "Malinga", "Rohit", "Dhawan"
    )


    var name = "Dhawan"
    println(
        "The set contains the element $name or not?" +
                "   " + captains.contains(name)
    )

    var num = 5
    println(
        "The set contains the element $num or not?" +
                "   " + captains.contains(num)
    )

    println(
        "The set contains the given elements or not?" +
                "   " + captains.containsAll(setOf(1, 3, "Root"))
    )


}

fun checkingEqualityOfEmptySet() {
    //creating an empty set of strings
    val seta = mutableSetOf<String>()
    //creating an empty set of integers
    val setb = mutableSetOf<Int>()


    //checking if set is empty or not
    println("seta.isEmpty() is ${seta.isEmpty()}")

    // Since Empty sets are equal

    //checking if two sets are equal or not
    println("seta == setb is ${seta == setb}")

    println(seta) //printing first set
}

fun setInKotlin() {

    /*Set:Store unique element in an undifined order
* group of unique element
* the order has no significance
* we can iterate over them but order is not defined*/

    val unOrderedSetImmutable = setOf("one", "two", "one") //immutable set


    print("unOrderedSet :$unOrderedSetImmutable")  //removes duplicate

    /*we can create empty set but we need to specify the type of set*/
    val emptySet = setOf<String>()
    val emptySetWithNull = setOf<String?>()

    // set can contain null element but only one null
    val setWithNullValue = setOf(null, "sdsf", "asda")

    /*we can add or remove element in setOf()*/
    //unOrderedSetImmutable.add()

    /*to add element to set and remove element from set ,we need mutableSet which is HashSet
    * we can create empty hashSet and can hole null value */


    val ImmutableList = listOf(3, 4, 5)

    /*we can add element to hashSet()*/
    mutableHash.add(3)

    //another way to add elements is by using listOf() function
    mutableHash += listOf(8, 9)

    /*Add another collection to hashSet()*/
    mutableHash.addAll(ImmutableList)

    println(mutableHash)


    /*remove element*/
    mutableHash.remove(2)

    /*we can not remove element at some Index like in list because order is not preserved in set*/
    // mutableHash.removeAt()

    /*remove collection from set*/
    mutableHash.removeAll(ImmutableList)

    val unOrderedSetMutable = mutableSetOf("one", "two") //immutable set
    unOrderedSetMutable.add("three")
    println(unOrderedSetMutable)
    // unOrderedSet.add()->will throw error

    println(unOrderedSetMutable.add("three"))//return false because duplicate not aloud


}

fun listInKotlin() {

    /*List:
* ordered collection
* element can be accessed by the position (index)
* can contain duplicate element and null values*/


    /*here no need to mention list type because system knows it is list of string type*/
    val fruitList = listOf("Apple", "Banana", "Apple", null) //immutable

/*if we create empty list ,we need to specify the element type*/
    var emptyList = listOf<String>()

/*mutable list in which we can add or remove*/
    val fruitListArrayList = arrayListOf("Apple", "Banana") //mutable
    val fruitListArrayList1 = arrayListOf("Apple", "Banana") //mutable
    var emptyArrayList = arrayListOf<String>() //mutable


    val systemUsers = mutableListOf(1, 2, 3)//mutable


    val fruitListMutable: MutableList<String> = mutableListOf("Apple", "Banana") //mutable
    val readOnly: List<String> = fruitListMutable //immutable read only list


    //we can not  add or remove element in immutable list but we can retrieve element of the list
    // fruitList.add("jzh")
    println(fruitList[0])

    /*if index is grater than the size of list we will get exception
    .ArrayIndexOutOfBoundsException:Index 5 out of bounds for length 4*/
    // println(fruitList[5])


    /*another way to get element
    * */
    println(fruitList.get(1))
    println(fruitList.size)

    /*add another collection into collection*/
    fruitListArrayList.add("orange")
    fruitListArrayList.addAll(fruitListArrayList1)
    fruitListArrayList.addAll(emptyArrayList)
    println(fruitListArrayList)


    /*remove from arrayList using element
    * if list contain duplicate element ,it will only remove first element*/
    fruitListArrayList.remove("Apple")
    println("After removed element Apple:$fruitListArrayList")

    /*remove from arrayList using index*/
    fruitListArrayList.removeAt(0)
    println("After removed index 0:$fruitListArrayList")

    /*remove collection from another collection*/
    fruitListArrayList.removeAll(fruitListArrayList1)
    println("After removed All collection:$fruitListArrayList")



    fruitListMutable.add("pineapple");
    println(fruitListMutable)

    // readOnly.add() ->will throw error
}

