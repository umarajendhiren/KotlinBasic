package com.androidapps.basic.interviewQuestion;

public class fibonacciSeries {

    /*In fibonacci series, next number is the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc.
     The first two numbers of fibonacci series are 0 and 1.*/
    public static void main(String[] args) {
       /* Scanner scanner=new Scanner(System.in);

        System.out.println("Enter number to find fibonacci:");
        int input=scanner.nextInt();
        System.out.println("fib = " +  fibonacciUsingForLoop(input));;*/

        //this recursive method do same thing again and again.so this is not efficient
        // System.out.println(fib(9));

        //Using array is efficient than recursive but if i give 100 .it will align space for 100 variable when i run loop .so this one is not memory efficient.
        // System.out.println(fibUsingArray(9));

        //this method, only create space for three variable .so this one is more efficient.
        //  System.out.println(fibUsingTempVariable(5));

       // System.out.println(fib(10));
        //fibUsingArray(10);
         fibUsingTempVariable(10);


    }

    public static int fib(int n) {

        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);

    }

    public static int fibUsingArray(int n) {

        if (n <= 1) {
            System.out.println(n);
            return n;
        }
        int[] fibArray = new int[n + 1];

        fibArray[0] = 0;
        fibArray[1] = 1;
        System.out.println(fibArray[0]);
        System.out.println(fibArray[1]);

        for (int i = 2; i <= n; i++) {

            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];

            System.out.println(fibArray[i]);
        }
        return fibArray[n];
    }

    public static int fibUsingTempVariable(int n) {


        if (n <= 0) {
            System.out.println(n);
            return n;
        }
        int a = 0, b = 1, c = 0;
        System.out.println(a);
        System.out.println(b);

        for (int i = 2; i <= n; i++) {

            c = a + b;
            a = b;
            b = c;
            System.out.println(c);
        }

        return c;


    }

}
