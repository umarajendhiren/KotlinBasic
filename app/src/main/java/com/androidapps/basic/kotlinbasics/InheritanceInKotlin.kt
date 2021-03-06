package com.androidapps.basic.kotlinbasics
/*A class inherits its values and function from another class
* We can apply variable and methods of  class to another class without recreating them, without redefining them*/


/*All classes in Kotlin have a common superclass, Any,
 which is the default superclass for a class with no supertypes declared:
 In java ,object class is the default superclass for all classes with no supertypes declared

 Any has three methods: equals(), hashCode(), and toString(). Thus, these methods are defined for all Kotlin classes.*/

class Example // Implicitly inherits from Any

//merge conflict
var lastname="Rajendhiren"

/*By default, Kotlin classes are final – they can’t be inherited.
To make a class inheritable, mark it with the open keyword:

The open modifier has no effect when added to members of a final class – a class without an open modifier.*/

open class BaseClass // Class is open for inheritance


//To declare an explicit supertype, place the type after a colon in the class header:

class DerivedClass(p: Int) : BaseClass()

/*Overriding methods:
Kotlin requires explicit modifiers for overridable members and overrides:

The override modifier is required for Circle.draw(). If it were missing, the compiler would complain.
 If there is no open modifier on a function, like Shape.fill(),
 declaring a method with the same signature in a subclass is not allowed, either with override or without it.
 The open modifier has no effect when added to members of a final class – a class without an open modifier.*/

open class Shape {
    open fun draw() { /*...*/
    }

    fun fill() { /*...*/
    }
}

open class Circle() : Shape() {
    override fun draw() { /*...*/
    }

    //we can not declare method in subclass with same signature as in super class

    /*fun fill() { *//*...*//*
    }*/
}

//A member marked override is itself open, so it may be overridden in subclasses.
// If you want to prohibit re-overriding, use final:

open class Rectanglee() : Circle() {
    final override fun draw() { /*...*/
    }
}

class rectSubClass() : Rectanglee() {

    //we can extend Rectanglee() class but  we can not override Draw() because member is final.
    //override fun draw()
}


/*Overriding properties:
The overriding mechanism works on properties in the same way that it does on methods.
 Properties declared on a superclass that are then re-declared on a derived class must be prefaced with override,
  and they must have a compatible type. Each declared property can be overridden by a property with an initializer
   or by a property with a get method:*/

open class Shapee {
    open val vertexCount: Int = 0
}

class Rectangleee : Shapee() {
    override val vertexCount = 4
}


/*You can also override a val property with a var property, but not vice versa.
 This is allowed because a val property essentially declares a get method,
and overriding it as a var additionally declares a set method in the derived class.*/
interface Shape1 {
    val vertexCount: Int
}

class Rectangle1(override val vertexCount: Int = 4) : Shape1 // Always has 4 vertices

class Polygon1 : Shape1 {
    override var vertexCount: Int = 0  // Can be set to any number later
}

/*Overriding rules:
In Kotlin, implementation inheritance is regulated by the following rule:
 if a class inherits multiple implementations of the same member from its immediate superclasses,
 it must override this member and provide its own implementation (perhaps, using one of the inherited ones).

To denote the supertype from which the inherited implementation is taken,
 use super qualified by the supertype name in angle brackets, such as super<Base>:*/

open class Rectangle2 {
    open fun draw() { /* ... */
    }
}

interface Polygon2 {
    fun draw() { /* ... */
    } // interface members are 'open' by default
}

class Square() : Rectangle2(), Polygon2 {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle2>.draw() // call to Rectangle.draw()
        super<Polygon2>.draw() // call to Polygon.draw()
    }
}




//if 2 or 3 classes has same properties and methods we can pack it as one using inheritance concept to avoid more duplicate code.

/*
ex ,i have class car which has model and make properties and it has break ,accelerate method.
and i have another class truck with same properties and methods as car class.
instead of declaring same fields and methods again and again in each and every class  we can create one common class with same fields and methods then we can inherit from that as many as we want .
in that way we can avoid more boilerplate code.
*/

open class Vehicle(var make:String,var model:String){

  open  fun details(){


        println("make is $make model is $model")

    }
    fun accelarate() {println("going in high speed")}
    fun applybreak(){println("stop")}
}

open class Car( var makeOfCar:String, var modelOfCar:String, var color:String): Vehicle(makeOfCar,modelOfCar){

    override fun details() {
        super.details()
        println("car color is $color")
    }


}

class Truck(var makeOfTruck:String ,var modelOfTruck:String,var colorOfTruck:String):Vehicle(makeOfTruck,modelOfTruck){

    override fun details() {
        super.details()
        println("truck color is $colorOfTruck")
    }
}





/*this class has access to variable and methods in Car and vehicle class*/
class ElectricCar(
    var makeOfElectric: String,
    var modelOfElectric: String,
    var colorOfElectricCar: String
) : Car(makeOfElectric, modelOfElectric, colorOfElectricCar)




/*A class Laptop has characteristics like screenSize and speed, and a function run() that prints out a message which includes its characteristics.
A class Apple is a Laptop, so it inherits the laptop characteristics.
However it has a smaller screen size.
Implement this in a program, call the method run in both Laptop and Apple, and observe the different values.
*/
open class Laptop() {
    open var screenSize = 32
    var speed = 1200
    var name = "Generic laptop"
    fun run() {
        println(" $name ScreenSize is $screenSize and Speed is $speed")
    }
}

class AppleLaptop : Laptop() {
    override var screenSize = 28

}




/*An Airplane has speed and altitude. It also two methods, ascend which increases altitude, and descend, which decreases altitude.
Create two classes that inherit from Airplane, Boeing and Airbus. They have different speeds.
Create objects, call methods and print out messages for both child classes.
*/

open class Airplane(var speedOfAirplane: Int) {
    var name="GenericAirPlane"
    var speed = speedOfAirplane
    var altitude = 938
    fun ascend() {
        println("increasing $name altitude")
    }

    fun descend() {
        println("decreasing $name altitude")
    }
}

class Boeing(var speedOfBoeing: Int) : Airplane(speedOfBoeing)


class Airbus(var speedOfAirBus: Int) : Airplane(speedOfAirBus)
fun main() {
    var car=Car("Honda","accord","Red")
    car.details();
    car.accelarate();
    car.applybreak()
    var truck=Truck("ford","67","blue")
    truck.details();
    truck.accelarate()
    truck.applybreak()


    var electricCar = ElectricCar("Honda", "electric", "blue")
    println(electricCar.color) //Car class variable
    println(electricCar.make) //Vehicle class variable
    println(electricCar.model) //Vehicle class variable


    var laptop = Laptop()
    // println("Laptop size is  ${laptop.screenSize} ")
    laptop.run()

    var appleLaptop = AppleLaptop()
    appleLaptop.name = "Apple laptop"
    //println("Apple Laptop size is  ${appleLaptop.screenSize} ")
    appleLaptop.run()

    var genericAirplane = Airplane(1000)
    println("genericAirplane speed is ${genericAirplane.speed}")
    genericAirplane.ascend()

    var boeingAirplane=Boeing(700)
    boeingAirplane.name="Boeing"
    println("boeingAirplane speed is ${boeingAirplane.speed}")
    boeingAirplane.descend()

    var airBus=Airbus(500)
    airBus.name="AirBus"
    println("airBus speed is ${airBus.speed}")
    airBus.ascend()
}