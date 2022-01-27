package com.androidapps.basic.kotlinbasics

/*init block is the component of the class .allow us to run first thing we do when class instantiated
* when we create object for that class ,first thing that happens is init block will run
* inti block provides functionality in addition to primary constructor*/

class Car1{
    var make="Honda"
    var model="Accord"
    init {

        println("This car make is $make and model is $model")
    }
}

class  Laptop1(operatingSystem:String){
    init {
        println("The operating system $operatingSystem installing..")
    }
}

fun main(param:Array<String>){

    var carInstance=Car1()  //here we are not calling anything using car instance .but init block will be executed when we create this instance
    var laptopInstance=Laptop1("Windows 10")
}