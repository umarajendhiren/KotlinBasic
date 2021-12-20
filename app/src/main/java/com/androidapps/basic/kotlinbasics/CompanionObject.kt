package com.androidapps.basic.kotlinbasics

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
        var name:String="abc"
    }
}

val a = MyClass1.name

class MyClass2 {
    companion object {
        var name:String="abc"
    }
}

val b = MyClass2.name



/*Semantic difference between object expressions and declarations:
There is one important semantic difference between object expressions and object declarations:

Object expressions are executed (and initialized) immediately, where they are used.

Object declarations are initialized lazily, when accessed for the first time.

A companion object is initialized when the corresponding class is loaded (resolved) that matches the semantics of a Java static initializer.*/