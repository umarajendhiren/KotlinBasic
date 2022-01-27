package com.androidapps.basic.kotlinbasics

/*Companion object:
* this is the way to make a code available from a class without need of the object.this is static code*/

/*An object declaration inside a class can be marked with the companion keyword:*/

class CompanionObject {
    companion object Named {
        fun create(): MyClass = MyClass()
    }

}

/*Members of the companion object can be called simply by using the class name as the qualifier:*/
val x = CompanionObject.create()


//The name of the companion object can be omitted, in which case the name Companion will be used:

class classWithOutCompanionObjectMember {
    companion object {}
}

val y = classWithOutCompanionObjectMember.Companion


/*The name of a class used by itself (not as a qualifier to another name)
acts as a reference to the companion object of the class (whether named or not):*/

class MyClass1 {
    companion object Named {
        var name: String = "abc"
    }
}

val a = MyClass1.name

class MyClass2 {
    companion object {
        var name: String = "abc"
    }
}

val b = MyClass2.name


class CarCompanionExp1 {
    companion object {
        fun startDriving(): String {
            return "Car is running!"
        }
    }
}


/*A class KotlinCourse will provide Kotlin information.
 It will also provide some general information about the course without needing an object to be created.
Implement this functionality in a program and display the general information.
*/

class KotlinCourse() {

    companion object {
        var generalInfo = "Kotlin is an easy language to lear"
    }

    fun getCourseInfo() {
        println("Kotlin is java based development language")
    }
}


/*A book class will provide information about the editor without the need to be instantiated.

It will also require this information - in the form of an editor object type - in the constructor.

Implement this in a program*/


class Book(val editor: Editor) {
    companion object {
        fun getEditor() = Editor("Editor name is kauthik")
    }
}

class Editor(var editorName: String) {

}

fun main(args: Array<String>) {
    var c = CarCompanionExp1.startDriving()
    println(c)

    println(KotlinCourse.generalInfo)

    var book = Book(Book.getEditor())
    println(book)
}


/*Semantic difference between object expressions and declarations:
There is one important semantic difference between object expressions and object declarations:

Object expressions are executed (and initialized) immediately, where they are used.

Object declarations are initialized lazily, when accessed for the first time.

A companion object is initialized when the corresponding class is loaded (resolved) that matches the semantics of a Java static initializer.*/