package com.androidapps.basic.kotlinbasics

/*ex:when we create empty array list we need to specify which type of list it is like string list or integer list
* sometime we don't wants to specify type if we don't know the type of data that we are going to insert when we get the data from server or somewhere
* that time we can make the list type as generics*/

class Box<T> {
    fun display(item: T) {
        println(item)
    }
}

/*we can have multiple generics separated by comma */
class NewBox<T, U> {
    fun display(item1: T, item2: U) {
        println("$item1 $item2")
    }
}


/*Create a class that takes a generic type T, and has a function that takes an element of type T,
converts it to a String and prints the length of that String.
Create different objects of that class and invoke the function.
*/
class ConvertToString<T> {
    fun convert(item: T) {
        println("length of $item is ${item.toString().length}")
    }
}


//Type parameters:
//we can restrict type of generic parameter

abstract class Fruit1 {
    abstract fun peel()
}

class Apple1 : Fruit1() {
    override fun peel() {
        println("peeling the apple")
    }
}

class Banana : Fruit1() {
    override fun peel() {
        println("peeling the banana")
    }


}

/*here we can  pass any class which implements Fruit class .restricted */
class Chef<T : Fruit1> {
    fun cook(item: T) {
        item.peel()
    }
}


//type parameter example

/*A class can take a generic type of Collection of Strings.
It has a function that iterates through the elements, converts them to String and prints them out to the console.
Instantiate the class with different types of collections and call the function.
*/

//am  creating the class with generic  argument of  type Collection of type String
//here we can pass any collection of type string Set<String>,List<String> not Set<Int> and List<Int>
class Printer<T : Collection<String>> {
    fun printElement(collection: T) {
        collection.forEach { println(it.toString()) }
    }
}


/*Create an abstract class Shape that defines a method getArea which takes an argument size. Create two subclasses, Square and Circle, that inherit from Shape, and implement the method.

    Square area = size * size

    Circle area = size * size * 3.1415

Create another class Geometry that takes a generic argument of type Shape, and has a method that prints a message which includes the area of the shape that is passed.

Instantiate the Geometry class and print the area of the shape.*/

abstract class Shape2 {
    abstract fun getArea(size: Int): Double
}

class Square1 : Shape2() {
    override fun getArea(size: Int): Double {
        return size * size.toDouble()
    }
}

class Circle1 : Shape2() {
    override fun getArea(size: Int): Double =
        size * size * 3.1415

}

// generic argument of type Shape
class Geometry<T : Shape2> {
    fun printAreaOFShape(shape: T, size: Int) {
        println(shape.getArea(size))
    }
}

fun main(args: Array<String>) {
    var boxString = Box<String>() //when we create instance we should mention type of Box
    boxString.display("Content")

    var boxInt = Box<Int>()
    boxInt.display(4)

    var boxCar = Box<Car>()
    boxCar.display(Car("honda", "accord", "white"))// will print object id

    var newBox = NewBox<Int, Float>()
    newBox.display(5, 6.5F)

    var integerInstance = ConvertToString<Int>()
    integerInstance.convert(7899)

    var floatInstance = ConvertToString<Float>()
    floatInstance.convert(7.7F)


    var chefInstance1 = Chef<Apple1>()
    chefInstance1.cook(Apple1())

    var chefInstance2 = Chef<Banana>()
    chefInstance2.cook(Banana())

    //we can not pass string  because that String class did not implements Fruit class
    // var chefInstance3 = Chef<String>()


    val setInstance = setOf("thlkd", "dfdghg", "dgfhghgf", "thlkd") //not allow duplicate
    var printerInstance = Printer<Set<String>>()
    printerInstance.printElement(setInstance)

    val listInstance = listOf("th", "ghg", "ghgf")
    var printerInstance1 = Printer<List<String>>()
    printerInstance1.printElement(listInstance)


    var geometryInstance = Geometry<Circle1>()
    geometryInstance.printAreaOFShape(Circle1(), 8) //will call Circle class getArea()

    var geometryInstance1 = Geometry<Square1>()
    geometryInstance1.printAreaOFShape(Square1(), 4)  //will call Square class getArea()

}