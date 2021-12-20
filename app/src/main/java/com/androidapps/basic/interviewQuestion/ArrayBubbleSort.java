package com.androidapps.basic.interviewQuestion;

import java.util.Arrays;

public class ArrayBubbleSort {


    /**
     * Java program to sort integer array using bubble sort sorting algorithm.
     * bubble sort is one of the simplest sorting algorithm but performance
     * of bubble sort is not good, it's average and worst-case performance
     * ranges in O(n2) and that's why it is not used to sort a large set of
     * unsorted data. Bubble sort can be used for educational and testing
     * purpose to sort a small number of data to avoid the performance penalty.
     * This program is also a good example of how to print contents of Array in Java
     *
     * @author http://java67.blogspot.com
     */




        public static void main(String args[]) {
            //testing our bubble sort method in Java
            int[] unsorted = {32, 39,21, 45, 23, 3};
            bubbleSort(unsorted);

            //one more testing of our bubble sort code logic in Java
            int[] test = { 5, 3, 2, 1};
            bubbleSort(test);

        }

        /*
         * In bubble sort we need n-1 iteration to sort n elements
         * at end of first iteration larget number is sorted and subsequently numbers smaller
         * than that.
         */
        public static void bubbleSort(int[] unsorted){
            System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));

            // Outer loop - need n-1 iteration to sort n elements
            for(int i=0; i<unsorted.length -1; i++){

                //Inner loop to perform the comparison and swapping between adjacent numbers
                //After each iteration one index from last is sorted
                for(int j= 1; j<unsorted.length -i; j++){

                    //If the current number is greater than swap those two
                    if(unsorted[j-1] > unsorted[j]){
                        int temp = unsorted[j];
                        unsorted[j] = unsorted[j-1];
                        unsorted[j-1] = temp;
                    }
                }
                System.out.printf("unsorted array after %d pass %s: %n", i+1, Arrays.toString(unsorted));
            }
        }

    }

   /* Output:
    unsorted array before sorting : [32, 39, 21, 45, 23, 3]
    unsorted array after 1 pass [32, 21, 39, 23, 3, 45]:
    unsorted array after 2 pass [21, 32, 23, 3, 39, 45]:
    unsorted array after 3 pass [21, 23, 3, 32, 39, 45]:
    unsorted array after 4 pass [21, 3, 23, 32, 39, 45]:
    unsorted array after 5 pass [3, 21, 23, 32, 39, 45]:
    unsorted array before sorting : [5, 3, 2, 1]
    unsorted array after 1 pass [3, 2, 1, 5]:
    unsorted array after 2 pass [2, 1, 3, 5]:
    unsorted array after 3 pass [1, 2, 3, 5]*/


