package com.androidapps.basic.kotlinbasics

class enumBasics

/*define a collection of constants
* the constants defined are objects
* the constants have properties
* enum constants can be initialized
* constants have properties like
* name
* ordinal*/

/*some times we may need an object to holed constant only .that time we need to use enumeration concept.
* enumeration is named list of constants.
* Kotlin enums are classes
*
* Enum constants aren’t just collections of constants- these have properties, methods et
*
* Each of the enum constants acts as separate instances of the class and separated by commas
*
* An instance of enum class cannot be created using constructors
*
* enum class can implement interface.can not derive from a class.
* and also we can not extend enum class.because by default they are final .
*
* 1.Initializing enums –
* In Kotlin also enums can have a constructor like Java enums. Since enum constants are instances of an Enum class,
*  the constants can be initialized by passing specific values to the primary constructor. */


enum class Cards(val color: String) {
    Diamond("black"),
    Heart("red"),
}

val color = Cards.Diamond.color


fun enumPropertiesAndMethods() {
    /*As in Java and in other programming languages,
    Kotlin enum classes has some inbuilt properties and functions which can be used by the programmer.
    Here’s a look at the major properties and methods.

Properties –

ordinal: This property stores the ordinal value of the constant, which is usually a zero-based index.
name: This property stores the name of the constant.

Methods –

values: This method returns a list of all the constants defined within the enum class.
valueOf: This methods returns the enum constant defined in enum, matching the input string.
 If the constant, is not present in the enum, then an IllegalArgumentException is thrown.*/


}


enum class DAYS {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}


/*Enum class properties and functions –

Since enum class in Kotlin, defines a new type. This class type can have its own properties and functions.
 The properties can be given a default value, however, if not provided,
 then each constant should define its own value for the property. In the case of functions,
 they are usually defined within the companion objects so that they do not depend on specific instances of the class.
 However, they can be defined without companion objects also.*/


// A property with default value provided
enum class DAYSINWEEK(val isWeekend: Boolean = false) {
    SUNDAY(true),
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,

    // Default value overridden
    SATURDAY(true);

    companion object {
        fun today(obj: DAYSINWEEK): Boolean {
            return obj.name.compareTo("SATURDAY") == 0 || obj.name.compareTo("SUNDAY") == 0
        }
    }
}


/*Enums as Anonymous Classes –

Enum constants also behaves as anonymous classes by implementing their own functions along with overriding the abstract functions of the class.
 The most important thing is that each enum constant must be override.*/

// defining enum class
enum class Seasons(var weather: String) {


    Summer("hot") {
        // compile time error if not override the function foo()
        override fun foo() {
            println("Hot days of a year")
        }
    },
    Winter("cold") {
        override fun foo() {
            println("Cold days of a year")
        }
    },
    Rainy("moderate") {
        override fun foo() {
            println("Rainy days of a year")
        }
    };

    abstract fun foo()
}


/*Usage of when expression with enum class –

A great advantage of enum classes in Kotlin comes into play when they are combined with the when expression.
The advantage is since enum classes restrict the value a type can take,
 so when used with the when expression and the definition for all the constants are provided,
then the need of the else clause is completely eliminated. In fact, doing so will generate a warning from the compiler.*/










fun main() {

    // println(color);

    // A simple demonstration of properties and methods

    /* for (day in DAYS.values()) {
         println("${day.ordinal} = ${day.name}")
     }
     println("${DAYS.valueOf("WEDNESDAY")}")
 */


    // A simple demonstration of properties and methods

    /*  for(day in DAYSINWEEK.values()) {
          println("${day.ordinal} = ${day.name} and is weekend ${day.isWeekend}")
      }
      val today = DAYSINWEEK.MONDAY;
      println("Is today a weekend ${DAYSINWEEK.today(today)}")*/


    // calling foo() function override be Summer constant
    // Seasons.Summer.foo()

    val dayName = DAYS.SUNDAY

    when (dayName) {
        DAYS.SUNDAY -> println("Today is Sunday")
        DAYS.MONDAY -> println("Today is Monday")
        DAYS.TUESDAY -> println("Today is Tuesday")
        DAYS.WEDNESDAY -> println("Today is Wednesday")
        DAYS.THURSDAY -> println("Today is Thursday")
        DAYS.FRIDAY -> println("Today is Friday")
        DAYS.SATURDAY -> println("Today is Saturday")
        // Adding an else clause will generate a warning


    }


    decide(Colors.GREEN)

    println(Colors.RED.ordinal)
    println(Colors.GREEN.ordinal)
    println(Colors.BLUE.ordinal)

    println(Colors.GREEN.timesUsed)

    println(Colors.BLUE.name) //returns name of enum constants


    println("current state is playing and changed state is  ${changeState(GameState.Playing)}")


    var olympic = Olympic()
    println("place for gold is ${olympic.placeForMedals(Medals.Gold)}")
    olympic.medalForPlace(Medals.Bronze.place)
}

enum class Colors(var timesUsed: Int) {
    RED(8), GREEN(13), BLUE(timesUsed = 34)
}

fun decide(color: Colors) {
    when (color) {
        Colors.RED -> println("you chose red")
        Colors.BLUE -> println("you chose blue")
        Colors.GREEN -> println("you choose green")

    }
}


/*We have a game that only has three states
STARTED
PLAYING
GAMEOVER
The states can only move in the direction STARTED->PLAYING->GAMEOVER, so a game class has a function to move the game from one state to another.
Create the game class and an object that is used to move the game through the states and print the result.*/


enum class GameState {
    Started, Playing, GameOver
}

fun changeState(currentState: GameState): GameState {
    when (currentState) {
        GameState.Started -> return GameState.Playing
        GameState.Playing -> return GameState.GameOver
        GameState.GameOver -> return GameState.Started

    }
}


/*The medals in the olympics are

    GOLD - 1st place

    SILVER - 2nd place

    BRONZE - 3rd place

    NONE - other

Create a class Olympics that has a function which returns the medal a contestant won based on the position they finished on.
It also has a function which returns the position of a contestant based on the medal they won.
Create an object of that class and call its methods.*/


enum class Medals(var place: String) {
    Gold("1st place"),
    Silver("2nd place"),
    Bronze("3rd place"),
    None("other")
}

class Olympic {
    /* fun placeForMedals(medal: Medals) {
         when (medal) {
             Medals.Gold -> println("1st place")
             Medals.Silver -> println("2nd place")
             Medals.Bronze -> println("3rd place")
             Medals.None -> println("other")

         }
     }*/

    fun placeForMedals(medals: Medals) = medals.place

    fun medalForPlace(place: String) {
        when (place) {
            Medals.Gold.place -> println("Gold")
            Medals.Silver.place -> println("Silver")
            Medals.Bronze.place -> println("Bronze")
            Medals.None.place -> println("None")
        }
    }
}