package com.androidapps.basic.kotlinbasics

import kotlin.random.Random

/*interface is a definition of a part of a class
* tell you what a class /object can do
* object can access other object through their interfaces
* very smaller to abstract class
* can have method without implementation(just definition),method with implementation
* can be used as variable type
*
* a class can implement multiple interface
* an interface has no constructor
* an interface can implement methods but doesn't need to
* an interface can not initialize value but can update them
* an interface can inherit from another interface   */

interface Oven {
    var temp: Int
    fun turnOn()
    fun turnOff()
    fun cook(temp: Int) {

        println("cooking at  $temp degrees")
    }
}

class BoschOven : Oven {
    override var temp = 180


    override fun turnOn() {
        println("Turning On")
    }

    override fun turnOff() {
        println("Turning Off")
    }
}


/*A restaurant will always provide food and provide a bill.
You want to go to your local restaurant and ask them for some food, and then for the bill.
On another day, you go to another, fancier restaurant, order some food then ask for the bill.
Implement this in a program.
*/

interface Restaurant {
    fun provideFood()
    fun provideBill()
}

class LocalRestaurant : Restaurant {
    override fun provideFood() {
        println("Local restaurant provides food and drink")
    }

    override fun provideBill() {
        println("pay bill 25$")
    }
}

class FancyRestaurant : Restaurant {
    override fun provideFood() {
        println("fancy restaurant provides delicious food and drink")
    }

    override fun provideBill() {
        println("pay bill 100$")
    }
}


/*Create an interface Car that guarantees functionality for drive and park, as well as a speed.
Create a class BMW that implements the Car interface.
Create a CarFactory that provides cars.
Create a variable myCar and ask the CarFactory for a car. Call the various methods on your car, without knowing what type it is.
*/

interface Car2 {
    var speed: Int
    fun drive()
    fun park()
}

class BMW : Car2 {
    override var speed = 100

    override fun drive() {
        println("BMW driving at speed $speed kmh")
    }

    override fun park() {
        println("Parking BMW")
    }
}

class CarFactory {
    fun provideCar(): Car2 {
        return BMW()
    }
}


/*Coffee will wake you up but also quench your thirst.
There are different types of coffee, Arabica and Robusta.
But since you don’t really care about that, you just go to the coffee shop and ask for a coffee, which they will happily provide.

You will then drink the coffee to both wake you up and quench your thirst.

Implement this in a program.*/

interface Coffee {
    fun wakeUp()
    fun quenchThirst()
}

class Arabica : Coffee {
    override fun wakeUp() {
        println("waking you up with arabica")
    }

    override fun quenchThirst() {
        println("quenching thirst with arabica")
    }
}

class Robasta : Coffee {
    override fun wakeUp() {
        println("waking you up with robasta")
    }

    override fun quenchThirst() {
        println("quenching thirst with robasta")
    }
}

class CoffeeShop {
    fun provideCoffee(): Coffee {

        var randomNumber = Random.nextInt(5)
        println(randomNumber)
        if (randomNumber % 2 == 0)
            return Robasta()
        else return Arabica()
    }
}

fun main(args: Array<String>) {
    /*we can not create object for interface but we can implement this interface */
    var oven: Oven? = null
    oven?.temp
    oven?.cook(100)
    oven?.turnOn()
    oven?.turnOff()

    //var boschOven:Oven=BoschOven() //implementation of interface
    var boschOven: Oven = getOven()
    boschOven.turnOn()
    boschOven.cook(150)
    boschOven.turnOff()


    var res1: Restaurant = LocalRestaurant()
    res1.provideFood()
    res1.provideBill()

    var res2: Restaurant = FancyRestaurant()
    res2.provideFood()
    res2.provideBill()


    var factory = CarFactory()
    var car: Car2 = factory.provideCar()
    car.speed = 120
    car.drive()
    car.park()





    for (i in 1..5) {
        var coffee: Coffee = CoffeeShop().provideCoffee()
        coffee.wakeUp()
        coffee.quenchThirst()
    }
}

fun getOven(): BoschOven {
    /*here we can provide any implementation of Oven interface (any brand of oven)*/
    return BoschOven()


}