package com.androidapps.basic.kotlinbasics

/*in java, interface can only have abstract method ,static method ,default method .
   method only has just declaration not implementation.

   *  an abstract class can have both ,abstract method and method with implementation.
   *
   * 1.but in kotlin an interface can contain abstract method and method with implementation.
   *
   *2. What makes them different from abstract classes is that interfaces cannot store a state.
   *
   * 3.They can have properties, but these need to be abstract or provide accessor implementations */

interface kotlininterex

{

    //3
    val prop: Int // abstract

    fun foo()
    fun goo(){
        // optional body
        print(prop)
    }
}

class myChildClass(override val prop: Int=29) :kotlininterex {
    override fun foo() {
        TODO("Not yet implemented")
    }
}

/*Resolving overriding conflicts
When you declare many types in your supertype list, you may inherit more than one implementation of the same method:*/

interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo();
        super<B>.foo();
    }

    override fun bar() {
        TODO("Not yet implemented")
    }


}
