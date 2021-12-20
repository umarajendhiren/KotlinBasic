package com.androidapps.basic.interviewQuestion;

import java.util.Arrays;
import java.util.BitSet;

public class ArrayMissingNumber {
    public static void main(String[] args) {

        //for only one missing number
        int[] arr1 = {7, 5, 6, 1, 4, 2};
        System.out.println("Missing number from array arr1: " + missingNumber(arr1));
        int[] arr2 = {5, 3, 1, 2};
        System.out.println("Missing number from array arr2: " + missingNumber(arr2));

        // one missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);
        // two missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
        // three missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
        // four missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

        missingNumberWithDuplicateArray();


    }

    public static int missingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        int restSum = 0;
        for (int i = 0; i < arr.length; i++) {
            restSum += arr[i];
        }
        int missingNumber = sum - restSum;
        return missingNumber;
    }

    /**
     * A general method to find missing values from an integer array in Java.
     * This method will work even if array has more than one missing element.
     */
    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }

    }

    public static int missingNumberFromSortedArray(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            throw new IllegalArgumentException("Null or Empty array not permitted");
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = (right + left) >> 1;
            if (numbers[middle] != middle) {
                if (middle == 0 || numbers[middle - 1] == middle - 1) {
                    return middle;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        throw new RuntimeException("No missing number");
    }

    public static void missingNumberWithDuplicateArray() {
        /*
         * Java Program to find missing numbers in an integer
         * array with duplicates. Array may contains more
         * than one duplicates.
         *
         * input: {1, 1, 2, 3, 5, 5, 7, 9, 9, 9};
         * output: 4, 6, 8
         */


                // given input
                int[] input = {1, 1, 2, 3, 5, 5, 7, 9, 9, 9};

                // let's create another array with same length
                // by default all index will contain zero
                // default value for int variable

                int[] register = new int[input.length];

                // now let's iterate over given array to
                // mark all present numbers in our register
                // array

                for (int i : input) {
                    register[i] = 1;
                }

                // now, let's print all the absentees
                System.out.println("missing numbers in given array");

                for (int i = 1; i < register.length; i++) {
                    if (register[i] == 0) {
                        System.out.println(i);
                    }
                }
            }

        }
     /*   Output
        missing numbers in given array
        4
        6
        8*/


