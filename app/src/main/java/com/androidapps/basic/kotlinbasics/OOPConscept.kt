package com.androidapps.basic.kotlinbasics

/*if we create app using 4 principle of OOP ,then app become scalable ,maintainable,easily debuggable
* it helps developers  to write clean and maintainable code
* it guide how a program is divided into component */

/*inheritance:
* classes can inherit methods and parameter from other classes
* to make a class inheritable ,we need to use open keyword followed by class name
* if parent class has more constructors ,at least one must be initialised when we inherit
* ex:class Child:Parent()
* child class can override methods and variables in parent class using override keyword if they are marked as open
* child class can access parent class methods and variables using the super keyword
* in that way we can avoid more boilerplate code and duplication of code*/


/*A class Father has a first name and last name. It also has a function that prints out the person’s name.

A class Son inherits from Father and overrides the first name. It also overrides the message function, which now prints out both the name of the person, and the name of the father.

Implement this structure in a program.*/

open class Father {
    open var firstName = "fatherFirstName"
    open var lastName = "fathersLastName"
    open fun printNames() {
        println("my name is $firstName $lastName")
    }
}

class Son : Father() {
    override var firstName = "SonFirstName"
    override var lastName = "SonLastName"
    override fun printNames() {
        super.printNames() //prints son's details
        println("father's name is ${super.firstName} ${super.lastName}")  //prints faters details
    }
}
/*encapsulation:
* hiding class detail from others
*we can achieve this using modifier private and protected
* ex:i have a class which has variable username of type String
* if it is public any class can access that variable and modify them
* if it is private ,they can only access that variable through getter and setter
* if we don't have setter for that private variable  no one can change that variable name*/


class EncryptionLock(var privateKey: Int) {

    var publicKey = 0;
    private fun isValid(): Boolean {
        return privateKey == publicKey

    }

    fun unlock(publicKey: Int) {
        this.publicKey = publicKey
        var isValidKey = isValid()
        if (isValidKey)
            println("Unlocked!")
        else
            println("Please use correct key!")
    }
}

/*abstraction
* it similar to inheritance.
* A common feature of two classes should be abstracted in a third class
* if two classes has same functionality or common  future ,we should extract those functionality into third class(Super class) and need to make that other two classes inherit from third class
* interface uses the basic idea of abstraction
* the keyword "abstract" means class can not be instantiated only extended from*/

class Bottle {
    fun pour() {
        println("pouring liquid")
    }
}

class Jug {
    fun pour() {
        println("pouring liquid")  //code duplication
    }
}

/*To reduce code duplication we can create abstract class but we can not create object for this container class*/
abstract class Container {
    //if we want common implementation
    /* fun pour() {
         println("pouring liquid")
     }*/

    //if we want unique implementation in each child
    abstract fun pour()
}

class Bottle1 : Container() {
    override fun pour() {
        println("pouring bottle liquid")
    }

    fun fill() {
        println("filling bottle")
    }
}

class Jug1 : Container()   //function reused
{
    override fun pour() {
        println("pouring jug liquid")
    }
}


/*
A class Dog can run, bark and play.
A Pug can run and play but cannot bark.
A Basset Hound can bark and play but cannot run.
An old Chihuahua can bark and run but cannot play.
Implement this in a program and print out what each dog breed can and cannot do.
*/

abstract class Dog(name: String) {
    abstract fun run()
    abstract fun play()
    abstract fun bark()
}

/*if we  extend abstract class we need to implement all it's abstract method.*/
class DogType1(var type1: String) : Dog(type1) {
    override fun run() {
        println("$type1 Can run")
    }

    override fun play() {
        println("$type1 Can play")
    }

    override fun bark() {
        println("$type1 Can't bark")
    }
}

class DogType2(var type2: String) : Dog(type2) {
    override fun run() {
        println("$type2 Can run")
    }

    override fun play() {
        println("$type2 Can't play")
    }

    override fun bark() {
        println("$type2 Can bark")
    }
}


/*A default oven has an average cooking speed, top temperature and function for cooking.

A Bosch oven has a higher cooking temperature.

A Roaster oven does not cook but roasts. The speed and temperature are average.

Implement this in a program and print out the various information for the objects.*/

abstract class defaultOven() {
    val cookingSpeed = 120
    open val averageCooingTemperature = 100
    abstract fun cooking()
}

class Bosch : defaultOven() {
    override val averageCooingTemperature = 140
    override fun cooking() {
        println("Bosch Cooking At temp ${averageCooingTemperature}F and cooking speed is $cookingSpeed min")
    }
}

class Roster : defaultOven() {
    override fun cooking() {
        println("This Roaster oven doesn't cook but roast at temp ${averageCooingTemperature}F and cooking speed is $cookingSpeed min")
    }
}


/*polymorphism:
* one name ,many forms
* A function can do different things in different situation
* 2 types:
* Dynamic:method overriding
* static:method overloading*/


/*method overriding in child class*/
open class Mom {
    open fun say(message: String) {
        println("Mom says $message")
    }
}
/*here overriding method is not compulsory*/

class Daughter : Mom() {
    override fun say(message: String) {
        println("daughter says $message")
    }
}


/*method overloading in same class
* type of parameter is important in method overloading*/

class Mom1 {
    fun say(message: String) {
        println("Mom1 says $message")
    }

    fun say() {
        println("Mom1 says Hi!")
    }

    fun say(times: Int) {
        println("Mom1 says Hi! $times times")
    }

}


/*A Translator can provide a hello message in english by default, but also in two different languages.
If the language is not known, a default english message is provided.
Implement the Translator class and call an object from it with different language parameters.
*/

class Translator() {
    fun sayHello() {
        println("English:Hello!")
    }

    fun sayHello(language: String) {
        when (language) {
            "Tamil" -> println("Tamil:Vanakkam!")
            "Hindi" -> println("Hindi:Namashthe!")
            else -> println("English:Hello")
        }
    }
}


/*Scope:
*  variables and functions are available only in the block of code they are declared in
* classes can change the scope of variable /functions
* modifiers:
* private:visible inside class only.other classes,object ,component can not access that .
* (we can not call super.variable name if variable is private)
* protected:visible inside class and inheriting classes
* we can call super.variableName if variable is protected
* internal:visible inside the package .if another class inside package ,that can access internal variable
* public:visible to anyone(default)*/

fun main(args: Array<String>) {
    var sonInstance = Son()
    sonInstance.printNames()

    var encryptionLock = EncryptionLock(11)
    encryptionLock.unlock(3)
    encryptionLock.unlock(11)


    // var containerInstance=Container() //can not initiate abstract class

    var containerTypeInstance: Container = Bottle1()
    containerTypeInstance.pour()

    //here containerTypeInstance can not call fill() because instance is Container type
    //containerInstance.fill()


    var bottleTypeInstance = Bottle1()
    bottleTypeInstance.pour()
    bottleTypeInstance.fill()

    var type1 = DogType1("pug")
    var type2 = DogType1("basset")
    type1.bark()
    type1.play()
    type1.run()
    type2.bark()
    type2.play()
    type2.run()


    var bosch = Bosch()
    bosch.cooking()
    var roster = Roster()
    roster.cooking()


    /*polymorphism -method overriding*/
    var momInstance = Mom()
    momInstance.say("hai!")

    var daughterInstance = Daughter()
    daughterInstance.say("hello!")

    /*polymorphism -method overloading*/
    var mom1Instance = Mom1()
    mom1Instance.say()
    mom1Instance.say("Hello !")
    mom1Instance.say(3)

    var translatorInstance = Translator()
    translatorInstance.sayHello()
    translatorInstance.sayHello("Tamil")
    translatorInstance.sayHello("ksjdfh")
}

