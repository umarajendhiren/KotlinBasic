package com.androidapps.basic.kotlinbasics

sealed class SealedClassExample {


    /*Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance*/

    /*1.Declaration of sealed class — To declare a class as a sealed class we need to add a keyword sealed just before the class keyword
    * ex: sealed class Result
    *
    * 2.Sealed classes abstract by default so it  can not be instantiated.which means  We cannot create the object of a sealed class directly.And can have abstract members.
    *
    * 3.like abstract class ,subclass of sealed class can be any type of class like data class or object class or regular class or even another sealed class
    *
    * 4.in abstract class ,we can extend abstract class wherever we want like outside that file with in the project .
    * if we use "when" as expression else branch is must.
    * but in sealed class ,all subclass must be with in same file where the sealed class is declared.
    * if we use "when" as expression else branch is not mandatory.
    * we can not extend sealed class outside the file it's defined.if we do we will get compile time error like  "when' expression must be exhaustive.
    *
    * 5.use of sealed class is like enum class in java.enum class is data type that contains fixed set of constants.
    * it has no state.
    * what if instead of just one hardcoded "Error","Success", there are different dynamic error messages(the states of the objects), it is not possible using Enum.
    * by default enum classes are final by default so we can not extend enum class but we can extend sealed class .
    * but we can do it in sealed class.Sealed classes give us the flexibility of having different types of subclasses and also containing the state.
    *
    * For example, in the Enum class Result that is considered above, we are storing only the string values attached to the Enum.
    * But what if in the Error case, we want to display the actual Exception that has caused the error.
    * It is not possible with enums since Enum types cannot hold the state of the type.
    * in enum,else branch is not needed if we use "when" as expression
    *
    * enum class Result(val message: String) {
    SUCCESS("Success"),
    ERROR(val exception: Exception) // not possible with enums
        }
    *
    * in sealed class we can do
    *
    * sealed class Result {
     data class Success(val data: Data) : Result()
     data class Error(val exception: Exception) : Result()
}
    * that's the only different between two class.
    *
    * 6.Constructors of sealed classes can have one of two visibilities: protected (by default) or private.
    * we can't use public and internal visibility modifiers in sealed class
    *
    * 7.The key benefit of using sealed classes comes into play when you use them in a when expression.
    * there is no requirement to add an else case if we use "when" as expression ,
    * because compiler knows that the class is sealed and it only needs the expression for the three derived classes, no default else branch needed.
    * We need to add else branch for all other regular class or abstract class other than sealed class.  */


    //6

    /*  public  constructor(){

      }*/


    //3
    /*This is how we can have the state(numberOfDays, displayName, and etc) in the sealed class which is not possible with enum.*/
    class January(var numberOfDays: Int) : SealedClassExample()

    data class February(var displayName: String) : SealedClassExample()

    object March : SealedClassExample() {
        var numberOfDays: Int = 0
        var displayName: String = "March..."
    }

    //if we create new  subclass after all or new subclass outside this file, it will throw error like "when' expression must be exhaustive, add necessary 'is April' branch or 'else' branch instead"
    class April : SealedClassExample() {}

}

//7
fun sampleAccess(month: SealedClassExample) = when (month) {
    is SealedClassExample.January -> println("Number of days in January${month.numberOfDays}")
    is SealedClassExample.February -> println("Display name of February ${month.displayName}")
    is SealedClassExample.March -> println("Number of days & Display name of March ${month.numberOfDays} && ${month.displayName}")
    is SealedClassExample.April -> println("This is April month")
}


fun main() {

    val jan = SealedClassExample.January(31)
    val feb = SealedClassExample.February("Feb")

    sampleAccess(jan)
    sampleAccess(feb)

    var somePlant = getPlant()  //return type plant
    when (somePlant) {
        is Fruit -> println("Sweet Fruit")
        is Vegetable -> println("Tasty vegetable")
        //here we can give n number of Fruits and vegetables to know which plant it is
    }

    var vehicleName = getVehicle() //returns type vehicle
    when (vehicleName) {
        is Bicycle -> println("Bicycling is healthy")
        is Flight -> println("Flight is Faster")
    }
}


//5
/*

  enum class Result(val data: String) {
    SUCCESS("Success"),
    ERROR("Error")

}

class enumSubClass:Result("SUCCESS")
*/


/* example1*/

abstract class Plant
sealed class Fruit : Plant()
sealed class Vegetable : Plant()

/*we can not instantiate sealed classes .so we need to create class to use Plant class*/
class Apple : Fruit()
class Potato : Vegetable()

//fun getPlant(): Plant = Apple()
fun getPlant(): Plant = Potato()


/*A function getVehicle returns a type Vehicle that can either be a car or a bicycle.
If a bicycle is returned, print out a message saying it’s more healthy
If a car is returned, print out a message saying it’s faster
*/
abstract class Vehicle1
sealed class Bicycle : Vehicle1()
sealed class Flight : Vehicle1()

class RoyalBabyBicycle : Bicycle()
class UnitedAirLines : Flight()

fun getVehicle(): Vehicle1 = RoyalBabyBicycle()
//fun getVehicle():Vehicle1=UnitedAirLines()


