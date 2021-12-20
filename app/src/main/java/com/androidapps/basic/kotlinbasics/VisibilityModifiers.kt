package com.androidapps.basic.kotlinbasics

/*There are four visibility modifiers in Kotlin: private, protected, internal, and public.
The default visibility is public.

* If you don’t use a visibility modifier, public is used by default, which means that your declarations will be visible everywhere.

If you mark a declaration as private, it will only be visible inside the file that contains the declaration.

If you mark it as internal, it will be visible everywhere in the same module.

The protected modifier is not available for top-level declarations.*/


//package  member

private fun foo() {  } // visible inside example.kt

public var bar: Int = 5 // property is visible everywhere
    private set         // setter is visible only in example.kt

internal val baz = 6    // visible inside the same module

//class member

/*For members declared inside a class:

private means that the member is visible inside this class only (including all its members).

protected means that the member has the same visibility as one marked as private, but that it is also visible in subclasses.

internal means that any client inside this module who sees the declaring class sees its internal members.

public means that any client who sees the declaring class sees its public members.

In Kotlin, an outer class does not see private members of its inner classes.

If you override a protected or an internal member and do not specify the visibility explicitly,
the overriding member will also have the same visibility as the original.*/