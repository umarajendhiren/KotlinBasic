package com.androidapps.basic.kotlinbasics

/*Type aliases provide alternative names for existing types.
If the type name is too long you can introduce a different shorter name and use the new one instead.
You can have new names for inner and nested classes*/

class MyClassNameA {
    inner class Inner
}

class MyClassNameB {
    inner class Inner
}

typealias AInner = MyClassNameA.Inner
typealias BInner = MyClassNameB.Inner