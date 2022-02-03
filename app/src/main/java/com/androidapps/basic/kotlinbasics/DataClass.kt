package com.androidapps.basic.kotlinbasics

class DataClass

/*it is the class  just to store data.only has getters and setters

* ex:if we get data JSON format data from backend server,we need to store that data in this class to use further
 in java ,we call this as POJO class.in kotlin ,we call this Data class
 primary constructor has at least one parameter
 all primary constructor parameters need to be var or val
 can have body but not required

 Automatically generated class methods:
 equals() or == ->compare data not object reference
 toString()  ->prints out variable names and data
 copy()-> creates a copy with only with some data changed */


/*To create the model class to hold data only ,we need to create data class
* to create data class ,we need to add just data keyword in front of class keyword.
* for the data class compiler derive some functionality for us like
* equals(),hashCode(),toString(),copy()
*
* Rules to create Data classes –
 Data classes have to fulfill the following requirements to ensure the consistency:
 * The primary constructor needs to have at least one parameter.
 * All primary constructor parameters need to be marked as val or var.
 * Data classes cannot be abstract, open, sealed or inner.
 * Data classes may only implement interfaces.
 * If there are explicit implementations of equals(), hashCode(), or toString() in the data class body or final implementations in a superclass,
 * then these functions are not generated, and the existing implementations are used.
 * Providing explicit implementations for the componentN() and copy() functions is not allowed.
*/

/* fun main(args: Array<String>) {
     //declaring a data class
     data class man(val roll: Int, val name: String, val height: Int)

     //declaring a variable of the above data class
     //and initializing values to all parameters

     val man1 = man(1, "man", 50)

     //printing all the details of the data class
     println(man1.toString());//This function returns a string of all the parameters defined in the data class

 }
*/


/*The compiler only uses the properties defined inside the primary constructor for the automatically generated functions.
        It excludes the properties that are declared in the class body*/

/*fun main(args: Array<String>) {
    //declaring a data class
    data class man(val name: String) {
        //property declared in class body
        var height: Int = 0;
    }

    //declaring a variable of the above data class and
    //initializing values to all parameters

    val man1 = man("manish")
    //class body properties must be assigned uniquely
    man1.height = 70

    //this method prints the details of class that
    //are declared in primary constructor
    println(man1);//Here height is not used by the toString() function

    //printing the height of man1
    println(man1.height);


    //when we print object of class using println(man1) ,we will get some unique code
    //but if we print object of data class we will get value of that class parameters
}*/


/*copy()

Sometimes we need to copy an object, with some change in some of its properties keeping all others unchanged.
In this case copy() function is used.
Properties of copy()

It copies all arguments or members defined in primary constructor
Two objects can have same primary parameter values and different class body values if defined*/


/*fun main(args: Array<String>)
{
    //declaring a data class
    data class man(val name: String, val age: Int)
    {
        //property declared in class body
        var height: Int = 0;
    }

    val man1 = man("manish",18)

    //copying details of man1 with change in name of man
    val man2 = man1.copy(name="rahul")

    //copying all details of man1 to man3
    val man3 = man1.copy();

    //declaring heights of individual men
    man1.height=100
    man2.height=90
    man3.height=110

    //man1 & man3 have different class body values,
    //but same parameter values

    //printing info all 3 men
    println("${man1} has ${man1.height} cm height")
    println("${man2} has ${man2.height} cm height")
    println("${man3} has ${man3.height} cm height")

}*/


/*hashCode() and equals()
hashCode() function returns a hash code value for the object.
equals() method return true if two objects have same contents and it works similar to “==”, but works different for Float and Double values.
Declaration of hashCode() :

open fun hashCode(): Int
Properties of hashCode()

Two hash codes declared two times on same object will be equal.
If two objects are equal according to equals() method, then the hash codes
returned will also be same*/



fun main(args: Array<String>) {
    //declaring a data class
    data class man(val name: String, val age: Int)

    val man1 = man("manish", 18)
    val man2 = man1.copy(name = "rahul")
    val man3 = man1.copy();

    val hash1 = man1.hashCode();
    val hash2 = man2.hashCode();
    val hash3 = man3.hashCode();

    println(hash1)
    println(hash2)
    println(hash3)

    //checking equality of these hash codes
    println("hash1 == hash 2 ${hash1.equals(hash2)}")
    println("hash2 == hash 3 ${hash2.equals(hash3)}")
    println("hash1 == hash 3 ${hash1.equals(hash3)}")


    /*man1 and man3 have same object contents, so they are equal, thus they have same hash code values*/

    /*Component functions generated for data classes make it possible to use them in destructuring declarations:*/
    val (name, age) = man1;
    println("name is $name and his age is $age")


    // ==
    val regularClassObject1 = RegularClass("someOne", 50)
    var regularClassObject2 = RegularClass("someOne", 50)
    println(regularClassObject1 == regularClassObject2)  //compare object references are equal or not(false)

    var dataClassObject1 = DataClass1("someOne", 50)
    var dataClassObject2 = DataClass1("someOne", 50)
    println(dataClassObject1 == dataClassObject2)  //compare object values are equal or not(true)


    //toString()
    println(regularClassObject1)  //regular class object will print object code(toString is hidden here)
    println(dataClassObject1)  //data class object will print information contained in that object

    //copy()
    //for regular class copy() is not available
    println(dataClassObject1.toString())
    var dataclassObject3 = dataClassObject1.copy(name = "rjg")
    println(dataclassObject3.toString())


    var article1FromServer=Article("title1","content1",2)
    var article2FromServer=Article("title2","content2",4)
    var updateArticle1=article1FromServer.copy("updatedTitle1")
    var updateArticle2=article2FromServer.copy("updatedTitle2")
    println(article1FromServer)
    println(article2FromServer)
    println(updateArticle1)
    println(updateArticle2)

}


class RegularClass(
    var name: String,
    var age: Int
)

data class DataClass1(
    var name: String,
    var age: Int
)


/*Exercise: Data classes

A network server responds with this information about blog articles

    Title

    Content

    Number of readers

You receive 2 articles from the server.

Update the title to suit your blog but also keep the originals.

Print out all the article information.*/


data class Article(var title: String, var content: String, var numberOfReaders: Int)