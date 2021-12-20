package com.androidapps.basic.interviewQuestion;

public class ArrayPrintEvenPositionElement {
    /*
    *posi:     1 , 2 , 3 , 4 , 5 , 6 , 7 , 8
    *        { 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 }
    * index:   0 , 1 , 2 , 3 , 4 , 5 , 6 , 7
    * */
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8};
        System.out.println("Elements of given array present on even position: ");
        //Loop through the array by incrementing value of i by 2
        //Here, i will start from 1 as first even positioned element is present at position 1.
        for (int i=1;i< arr.length;i=i+2){
            System.out.print(arr[i]+" ");
        }


        System.out.println("Elements of given array present on odd position: ");
        //Loop through the array by incrementing value of i by 2
        //Here, i will start from 1 as first even positioned element is present at position 1.
        for (int i=0;i< arr.length;i=i+2){
            System.out.print(arr[i]+" ");
        }
    }
}
