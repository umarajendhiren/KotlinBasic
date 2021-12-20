package com.androidapps.basic.kotlinbasics

class NestedAndInnerClass {

    /*A class can have inner class and inner interface
    * A interface also can have inner class and inner interface
    *
    * if outer class variable is private ,inner class can not access that variable.
    * if we put inner keyword in front of inner class we can access outer class private member*/

    private val bar: Int = 1

    class InnerClass{
       // fun foo()=bar; //this inner class can not access outer class private member
    }

    inner class InnerClassWithInnerKayWord{
        fun foo()=bar;
    }
    interface InnerInterface


}

interface OuterInterface{

    class InnerClass
    interface InnerInterface
}