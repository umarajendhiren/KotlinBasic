package com.androidapps.basic.kotlinbasics

/*nested class is created inside another class*/
class NestedAndInnerClass {

    /*A class can have inner class and inner interface
    * A interface also can have inner class and inner interface
    *
    * if outer class variable is private ,inner class can not access that variable.
    * if we put inner keyword in front of inner class we can access outer class private member*/

    private val bar: Int = 1

    class InnerClass {
        // fun foo()=bar; //this inner class can not access outer class private member
    }

    inner class InnerClassWithInnerKayWord {
        fun foo() = bar;
    }

    interface InnerInterface


}

interface OuterInterface {

    class InnerClass
    interface InnerInterface
}


//example
class Car4 {
    /*if the inner class is private ,outer class can create an instance of the inner class     */
    val engineInstance = Engine()

    private var speed = 100
    private fun drive() {
        println("driving at speed $speed")
        //engineInstance.run()
    }

    inner class Engine() {
        val rpm = 1000
        fun run() {
            println("engine is running at rpm $rpm")
            speed = 50
            drive()
            //another way
            /* this@Car4.speed=50
             this@Car4.drive()*/
        }
    }


}


/*Exercise: Nested classes

In order for an airplane to take off, it needs to have 2 engines, and they both need be running.

Create an Airplane class that has a takeoff method, which starts the engines and prints a take off message.*/

class Airplane1 {
    fun takeOff() {

        var engine1 = Engine("Engine1")
        var engine2 = Engine("Engine2")
        engine1.startEngine()
        engine2.startEngine()
        println("taking off")
    }

    private inner class Engine(var name: String) {
        fun startEngine() {
            println("$name is running")
        }


    }


}

fun main(args: Array<String>) {
    var car = Car4()
    car.Engine().run()

    var airplane1 = Airplane1()
    airplane1.takeOff()
}