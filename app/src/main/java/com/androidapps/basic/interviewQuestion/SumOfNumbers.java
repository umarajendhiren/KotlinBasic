package com.androidapps.basic.interviewQuestion;

public class SumOfNumbers {
    public static void main(String[] args) {
        sumOfNum(50);
        sumOfNum1(50);
    }

    private static void sumOfNum1(int n) {
        int sum=n*(n+1)/2;
        System.out.println("sumUsingFormila = " + sum);

    }

    private static void sumOfNum(int upto) {
        int sum=0;

        for(int i=1;i<=upto;i++){
            sum=sum+i;
        }
        System.out.println("sum = " + sum);
    }
}
