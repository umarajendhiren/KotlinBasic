package com.androidapps.basic.interviewQuestion;

public class factorial {
/*The factorial of an integer is calculated by multiplying all the numbers from 1 to the given number.*/
    public static void main(String[] args) {
       //System.out.println(factorialUsingRecursion(3));
        factorialUsingForLoop(1);
    }
    public static long factorialUsingRecursion(long n) {
        if (n == 1)
            return 1;
        else
            return (n * factorialUsingRecursion(n - 1));
    }

    public static void factorialUsingForLoop(int number){
        int fact=1;
        for (int i=1;i<=number;i++){
            fact=fact*i;
        }
        System.out.println("fact = " + fact);
    }

}
