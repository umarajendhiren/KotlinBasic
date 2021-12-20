package com.androidapps.basic.interviewQuestion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
    /*How to Generate Random Number in Java
In Java programming, we often required to generate random numbers while we develop applications. Many applications have the feature to generate numbers randomly, such as to verify the user many applications use the OTP. The best example of random numbers is dice. Because when we throw it, we get a random number between 1 to 6.

In this section, we will learn what is a random number and how to generate random numbers in Java.

Random Number
Random numbers are the numbers that use a large set of numbers and selects a number using the mathematical algorithm. It satisfies the following two conditions:

The generated values uniformly distributed over a definite interval.
It is impossible to guess the future value based on current and past values.
Generating Random Number in Java
In Java, there is three-way to generate random numbers using the method and classes.


Using the random() Method
Using the Random Class
Using the ThreadLocalRandom Class
Using the ints() Method (in Java 8)
*/


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
       // randomMethod();
        //usingRandomClass();
        //UsingTheadLocalRandom();
       // UsingInits(5);
        UsingInitsBound(5,1,20);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void UsingInitsBound(int streamSize, int origin, int boundry) {
        Random random=new Random();
        random.ints(streamSize,origin,boundry).forEach(System.out::println);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void UsingInits(int streamSize) {
        Random random=new Random();
        random.ints(streamSize).forEach(System.out::println);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static void UsingTheadLocalRandom() {

   // Generate random integers between 0 to 999
        int a = ThreadLocalRandom.current().nextInt();
        int b = ThreadLocalRandom.current().nextInt();
// Print random integer values
        System.out.println("Randomly Generated Integer Values:");
        System.out.println(a);
        System.out.println(b);
// Generate Random double values
        double c = ThreadLocalRandom.current().nextDouble();
        double d = ThreadLocalRandom.current().nextDouble();
// Print random doubles
        System.out.println("Randomly Generated Double Values:");
        System.out.println(c);
        System.out.println(d);
// Generate random boolean values
        boolean e = ThreadLocalRandom.current().nextBoolean();
        boolean f = ThreadLocalRandom.current().nextBoolean();
// Print random Booleans
        System.out.println("Randomly Generated Boolean Values:");
        System.out.println(e);
        System.out.println(f);
    }


    private static void usingRandomClass() {
        Random ran=new Random();
        System.out.println("randomDouble" + ran.nextDouble()); 
        System.out.println("randomDouble" + ran.nextDouble());

        System.out.println("nextLong" + ran.nextLong());
        System.out.println("nextLong" + ran.nextLong());

        System.out.println("randomfloat" + ran.nextFloat());
        System.out.println("randomfloat" + ran.nextFloat());

        System.out.println("randomint" + ran.nextInt()); 
        System.out.println("randomintWithBound" + ran.nextInt(10));

        System.out.println("ran.nextBoolean() = " + ran.nextBoolean());


    }

    private static void randomMethod() {

        System.out.println(Math.random());

        //random number between two numbers(200-400)
        //formula is Math.ramdom()*(max-min+1)+min

        int min=200,max=400;
        double randomDouble=Math.random()*(max-min+1)+min;
        System.out.println("randomDouble = " + randomDouble);

        int randomInt= (int) (Math.random()*(max-min+1)+min);
        System.out.println("randomInt = " + randomInt);

    }
}
