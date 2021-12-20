package com.androidapps.basic.interviewQuestion;

public class GivenNumberIsBinaryOrNot {
    public static void main(String[] args) {


      /*  for (int i = 1; i <= 50; i++) {
            if (i % (3 * 5) == 0) System.out.println("FizzBuzz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else System.out.println(i);
        }*/


        System.out.printf("Does number %d is a binary number? %b %n", 1010, isBinary(1010));
        System.out.printf("Does integer %d is a binary number? %b %n", 121, isBinary(121));
        System.out.printf("Does %d is a binary number? %b %n", 1011, isBinary(1011));
        System.out.printf("Does number %d is a binary number? %b %n", 111111, isBinary(111111));
        System.out.printf("Does %d is a binary number? %b %n", 1321, isBinary(1321));
    } /* * Java function to check if an integer is a binary number or not. */

    public static boolean isBinary(int number) {
        int copyOfInput = number;
        while (copyOfInput != 0) {
            if (copyOfInput % 10 > 1) {
                return false;
            }
            copyOfInput = copyOfInput / 10;
        }
        return true;
    }
}



