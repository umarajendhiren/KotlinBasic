package com.androidapps.basic.interviewQuestion;

import java.util.Scanner;

public class PrimeNumber {

    /*Prime number in Java: Prime number is a number that is greater than 1 and divided by 1 or itself only.
    In other words, prime numbers can't be divided by other numbers than itself or 1. For example 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.

Note: 0 and 1 are not prime numbers.
The 2 is the only even prime number because all the other even numbers can be divided by 2.*/
    static int givenNumber;

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number:");
        int start = s.nextInt();
        System.out.println("Enter last number:");
        int end = s.nextInt();

        for (int i = start; i <= end; i++) {
            if (isPrimeNumber(i))
                System.out.println(i + " is prime number");
            else
                System.out.println(i + " is not prime number");
        }

       /* if(isPrimeNumber(5))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");
        if(isPrimeNumber(6))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");
        if(isPrimeNumber(7))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");

        if(isPrimeNumber(19))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");
        if(isPrimeNumber(23))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");*/

/*
        if(isPrimeNumberUsingRoot(5))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");
        if(isPrimeNumberUsingRoot(6))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");
        if(isPrimeNumberUsingRoot(7))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");

        if(isPrimeNumberUsingRoot(19))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");
        if(isPrimeNumberUsingRoot(23))
            System.out.println(givenNumber+" is prime number");
        else
            System.out.println(givenNumber+" is not prime number");*/


    }


    /* this is not very memory and time-efficient.Math.sqrt() is more efficient than this*/
    private static boolean isPrimeNumber(int n) {
        givenNumber = n;
        int m = 0;
        m = n / 2;
        if (n <= 1) {
            return false;
        }
        if (n == 2)
            return true;
        for (int i = 2; i <= m; i++) {

            if (n % i == 0) {
                return false;
            }
        }


        return true;
    }

    private static boolean isPrimeNumberUsingRoot(int n) {
        givenNumber = n;
        if (n <= 1) {
            return false;

        }
        if (n == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                return false;
            }
        }


        return true;

    }

    /*
     * Prime number is not divisible by any number other than 1 and itself
     * @return true if number is prime
     */
    public static boolean isPrime(int number){
        for(int i=2; i<number; i++){
            if(number%i == 0){
                return false; //number is divisible so its not prime
            }
        }
        return true; //number is prime now
    }
}


