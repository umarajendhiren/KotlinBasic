package com.androidapps.basic.kotlinbasics

/*So let's say we have a higher-order function, which takes another function as a parameter

fun doSomething(block: () -> Unit){

}
the Kotlin compiler will convert this to equivalent Java code which would be,

void doSomething( new Function(){

  void invoke(){
      // the code which you passed in the functional parameter
   }

})
The Kotlin compiler creates an Anonymous Inner Class for the functional parameter you passed and when you call this passed functional parameter the compiler internally calls this invoke() method.

As a result, all functional parameter results in extra object creation and function call which is a performance and memory overhead.

We can avoid this overhead by introducing the inline modifier. When added to a function the function call is skipped and the function code is added at the call site instead.

So let's say we have a simple testing function,

inline fun testing(block : () -> Unit){

   println("Inside the testing block")
   block()
   someOtherRandomFunction()

}
and we call this testing function from the main function, like this

fun main(){

   testing{
           println("Passed from the main function")
   }

}
When the above main function gets compiled, it would look like

fun main(){

   println("Inside the testing block")
   println("Passed from the main function")
   someOtherRandomFunction()

}
As if no testing function ever existed, all the code body from the testing function is simply copy-pasted inside the main function body.*/


/*Using higher-order functions imposes certain runtime penalties: each function is an object, and it captures a closure. A closure is a scope of variables that can be accessed in the body of the function. Memory allocations (both for function objects and classes) and virtual calls introduce runtime overhead.

But it appears that in many cases this kind of overhead can be eliminated by inlining the lambda expressions. The functions shown below are good examples of this situation. The lock() function could be easily inlined at call-sites. Consider the following case:

lock(l) { foo() }
Copied!
Instead of creating a function object for the parameter and generating a call, the compiler could emit the following code:

l.lock()
try {
    foo()
} finally {
    l.unlock()
}
Copied!
To make the compiler do this, mark the lock() function with the inline modifier:

inline fun <T> lock(lock: Lock, body: () -> T): T { ... }
Copied!
The inline modifier affects both the function itself and the lambdas passed to it: all of those will be inlined into the call site.

Inlining may cause the generated code to grow. However, if you do it in a reasonable way (avoiding inlining large functions), it will pay off in performance, especially at "megamorphic" call-sites inside loops.*/



private val privatestring="myprivatestring"

@PublishedApi
internal val internalstring="myinternalstring"

public var publicstring="mypublicstring"



// inlined function

/*If you don’t want all of the lambdas passed to an inline function to be inlined,
mark some of your function parameters with the noinline modifier:*/
inline fun inlinedFunc( lmbd1: () -> Unit, noinline lmbd2: () -> Unit ) {
   lmbd1()
    lmbd2()

}

/*if higherOrder Inlined Function lambda Calling Another HigherOrderFunction we can not return from that.
for that we need to use crossinline to return from another*/
inline fun higherOrderInlinedFunctionlambdaCallingAnotherHigherOrderFunction( crossinline lamd:()->Unit){

    normalFunction{

        lamd()
    }
}

fun normalFunction(aLambda: () -> Unit) {
    aLambda()
    return

}

inline fun <T:Any> genericFuncWithoutReifiedKeyword() {
   // print(T::class)  shows compile time error that pass class instead of T
}
inline fun <reified T> genericFunc() {
    print(T::class)
}



inline fun accessVariableInsideInlineFunction(lamd: () -> Unit){

    ////ERROR: can't access this variable in an inline function.
   // print(privatestring.length)

    //Can access this variable because it's marked with @PublishedApi and internal
    print(internalstring.length)

    //Can access this variable, it's public
    print(publicstring.length)


}



fun main(args: Array<String>){
    println("Main function starts")

   /* inlinedFunc({ println("Lambda expression 1")
        return },	 // inlined function allow return
        // statement in lambda expression
        // so, does not give compile time error

        { println("Lambda expression 2")
            }  //second parameter of higher order function is noinline lambda .so we can not return
    )
*/


    higherOrderInlinedFunctionlambdaCallingAnotherHigherOrderFunction { print("Hai")
       // return  is not allowed here even if it is inlined function
    }

        println("Main function ends")



    genericFunc<String>()
}
