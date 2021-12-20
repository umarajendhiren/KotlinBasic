package com.androidapps.basic.interviewQuestion;

public class ArrayAverageOfNumbers {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,3,5};

        int total=0;
        float avrage=0;
        for(int i=0;i<arr.length;i++){
            total=total+arr[i];

        }
        avrage=total/arr.length;
        System.out.println(avrage);

        /*This happens because 14/5 becomes an integer division and the result of integer division is always an integer value, so 2.8 is cast into int and it becomes 2.0.

*/



        float floattotal=0;
        float floatavrage=0;
        for(int i=0;i<arr.length;i++){
            floattotal=floattotal+arr[i];

        }
        floatavrage=floattotal/arr.length;
        System.out.println(floatavrage);
    }
}
