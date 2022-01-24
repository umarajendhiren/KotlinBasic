package com.androidapps.basic.kotlinbasics
/*lambda function are function that don't have name.it's kind of anonymous function
* we can pass lambda function as a parameter into another function
*
* regular function has the structure like have fun keyword followed by name of function then within parenthesis we can pass parameters then need to write block of codes within curly braces
* but lambdas have only parameters then arrow then code for that function
*
* lambda function can be assigned to a variable
* the variable can be passed passes as a parameter to a new function (higher order function)
*
* concept is, we can able to create function on the fly to pass  to other function
*
* higher order function is a function that takes another function as a parameter */
fun main() {
    val printMyMessage = { message: String -> println(message) }
    printMyMessage("Hello kotlin!")

    val sumA = { x: Int, y: Int -> x + y }
    println(sumA(4, 3))

    val sumB: (Int, Int) -> Int = { x, y -> x + y }
    println(sumB(4, 1))

    /*   When we do web request ,we will send request to web and get result from web once its done.but we don't know exactly when we get the data.
    if we wait for that result,to update our UI ,app will freeze until the data available ,if we do request synchronously.
    to avoid freezing we need to use asynchronous concept .Using this we can use app even the app waiting for result from web.

*/



    fun downloadData(url: String, completion: ()-> Unit) {
        // sent a download request
        // we got back data
        // there were no network errors
        completion()
    }

    // call downloadDataFunction
    downloadData("fakeUrl.com") {
        println(
            "The code in this block, will only run" +
                    "after the completion()"
        )
    }

    fun downloadCarData(url: String, completion: (Car) -> Unit) {
        // send a download request
        // we got back car data
        val car = Car("Tesla", "ModelX","Blue")
        completion(car)
    }

    downloadCarData("fakeUrl.com"){ car ->
        println(car.color)
        println(car.make)
    }

    downloadCarData("fakeUrl.com"){
        println(it.color)
        println(it.make)
    }

    fun downloadTruckData(url: String, completion: (Truck?, Boolean) -> Unit) {
        // make the web request
        // we get the results back
        val webRequestSuccess = true
        if (webRequestSuccess) {
            // recieved truck data
            val truck = Truck("Ford", "F-150","blue")
            completion(truck, true)
        } else {
            completion(null, false)
        }
    }
/*if  truck is available and success is true */
    downloadTruckData("fakeUrl.com") { truck, success ->
        if (success == true) {
            // do something with our truck
            truck?.colorOfTruck
        } else {
            // handle the web request failure
            println("Something went wrong!")
        }
    }


}