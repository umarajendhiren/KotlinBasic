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


class EncryptionLock(var privateKey:Int) {

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
* if two classes has same functionality ,we should extract those functionality into third class and need to make that two classes inherit from third class*/

/*polymorphism:
* one name ,many forms*/


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

}