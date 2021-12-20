package com.androidapps.basic.javacollection;

import java.util.Scanner;

public class JavaInterviewQuestion {
    static int givenNumber;

    public static void main(String[] args) {
        System.out.println("ReversedString: " + ReverseTheString("uma"));
        System.out.println("emptyString:" + ReverseTheString(" "));
        System.out.println("NullString: " + ReverseTheString(null));

        SwapNumbers(10, 20);

        Scanner s=new Scanner(System.in);
        System.out.println("Enter first number:");
        int start=s.nextInt();
        System.out.println("Enter last number:");
        int end=s.nextInt();

        for(int i=start;i<=end;i++){
            if(isPrimeNumber(i))
                System.out.println(i+" is prime number");
            else
                System.out.println(i+" is not prime number");
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



    private static boolean isPrimeNumber(int n) {
       givenNumber=n;
        int m = 0;
        m = n / 2;
        if (n <=1) {
            return false;
        }
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
        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                return false;
            }
        }


        return true;

    }

    private static void SwapNumbers(int a, int b) {
        b = a + b;
        a = b - a;
        b = b - a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    private static String ReverseTheString(String input) {

        if (input == null || input.trim().isEmpty())
            return "invalid input";
        char[] characters = input.toCharArray();
        System.out.println("characters = " + characters);

        StringBuilder output = new StringBuilder();

        for (int i = characters.length - 1; i >= 0; i--) {

            output.append(characters[i]);

        }
        return output.toString();
    }
}
