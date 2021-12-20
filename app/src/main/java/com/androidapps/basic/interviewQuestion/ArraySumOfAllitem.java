package com.androidapps.basic.interviewQuestion;

public class ArraySumOfAllitem {
    public static void main(String[] args) {
        int[] array=new int[]{20,20,60};
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum=sum+array[i];
        }
        System.out.println("sum of all element = " + sum);
    }
}
