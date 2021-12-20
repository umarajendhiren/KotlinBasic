package com.androidapps.basic.interviewQuestion;

public class ArraySeparateOddAndEvenNumber {


    public static void main(String[] args) {

        int arr[] = {12, 17, 70, 15, 22, 65, 21, 90};
        System.out.println("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        arr = separateEvenOddNumbers(arr);
        System.out.println("nArray after separating even and odd numbers : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        separateNegativeAndPositiveNumber();
    }

    public static int[] separateEvenOddNumbers(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {

            while (arr[left] % 2 == 0) {
                left++;
            }
            while (arr[right] % 2 == 1) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return arr;
    }


    public static void separateNegativeAndPositiveNumber() {
        int[] arr = new int[]{-7, 4, 6, -4, 8, 6, -3};

        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            while (arr[left] > 0) {
                left++;
            }

            while (arr[right] < 0) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        System.out.println();
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
