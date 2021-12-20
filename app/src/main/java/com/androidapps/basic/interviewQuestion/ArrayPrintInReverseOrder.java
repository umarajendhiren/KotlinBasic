package com.androidapps.basic.interviewQuestion;

public class ArrayPrintInReverseOrder {
    public static void main(String[] args) {
        int[] original=new int[]{1,2,3,4,5,6,7};

        for(int i=original.length-1;i>=0;i--){
            System.out.print( original[i]+" ");
        }
    }
}
