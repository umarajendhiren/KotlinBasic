package com.androidapps.basic.kotlinbasics
/*kotlin is a language is built on top of java
* in kotlin everything is an object
* String,Float,Int,Boolean,HashMap all these are objects
* Collection and List are Interfaces*/
/*the "object" construct:
an "Object"  is a static class.All methods and variables can be accessed without an instance.
* Kind of singleton -one instance of a class.
* ex:if we wants to access database we should create one instance at a time .if multiple program try to access different instance database we end up with data inconsistency */


object MyDatabase {
    var isConnected = false

    fun connect() {
        isConnected = true
        println("Connected to database")
    }

    fun disconnect() {
        isConnected = false
        println("disconnected!")
    }
}

fun main() {

    /*here we are accessing database component directly without creating instance*/
    if (MyDatabase.isConnected) {
        MyDatabase.disconnect()
    } else {
        MyDatabase.connect()
    }

}