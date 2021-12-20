package com.androidapps.basic.interviewQuestion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array3rdLargestNumber {

    /*Note: Like the Arrays class, the Collections class also provides the sort() method to sort the array. But there is a difference between them.
    The sort() method of the Arrays class works for primitive type while the sort() method of the Collections class works for objects Collections, such as LinkedList, ArrayList, etc.*/
    public static void main(String[] args) {
       // get3rdLargestelement1();
      // get3rdLargestelement2();
       // get3rdLargestelement3();

        int[] arr1={7,5,6,1,4,2};
        int secondHighest=get2ndLargestNumberWithoutSort(arr1);
        System.out.println("Second largest element in the array : "+ secondHighest);

        get2ndLargestNumberAndSmallestWithoutSort();

    }

    private static void get2ndLargestNumberAndSmallestWithoutSort() {
        int[] arr=new int[]{10,20,30,30,40};

        int highest=arr[0];
        int secondHighest=arr[0];
        int lowest=arr[0];

        for(int i=0;i<arr.length;i++){
            if(arr[i]>highest){

                secondHighest=highest;
                highest=arr[i];

            }
            else if(arr[i]>secondHighest && arr[i]!=highest){
                secondHighest=arr[i];
            }

            else if(arr[i]<lowest && arr[i]!=highest && arr[i]!=secondHighest)

                lowest=arr[i];
        }
        System.out.println("highest "+highest);
        System.out.println("secondHighest "+secondHighest);
        System.out.println("lowest "+lowest);
    }

    private static int get2ndLargestNumberWithoutSort(int array[]) {

            // Initialize these to the smallest value possible
            int highest = Integer.MIN_VALUE;
            int secondHighest = Integer.MIN_VALUE;

            // Loop over the array
            for (int i = 0; i < array.length; i++) {
                // If current element is greater than highest
                if (array[i] > highest) {

                    // assign second highest element to highest element
                    secondHighest = highest;

                    // highest element to current element
                    highest = array[i];
                } else if (array[i] > secondHighest && array[i]!=highest)
                    // Just replace the second highest
                    secondHighest = array[i];
            }

            // After exiting the loop, secondHighest now represents the second
            // largest value in the array
            return secondHighest;
        }




    private static void get3rdLargestelement3() {
        Integer a[]={44,66,99,77,33,22,55};
        List<Integer> list= Arrays.asList(a);
        Collections.sort(list);
        System.out.println("3rd largest " +list.get(list.size()-3));

    }

    public static void get3rdLargestelement1(){
        int[] array1=new int[]{7,6,5,4,3,2,8};
        int temp;
        for(int i=0;i<array1.length;i++){

            for(int j=i+1;j<array1.length;j++){

                if(array1[i]>array1[j])//sort in ascending order
                {
                    temp=array1[i];
                    array1[i]=array1[j];
                    array1[j]=temp;

                }

            }

        }
        System.out.println("3rd largest " +array1[array1.length-3]);
    }

    public static void get3rdLargestelement2(){
        int[] array1=new int[]{7,6,5,4,3,2,8};
        Arrays.sort(array1);
        System.out.println("3rd largest " +array1[array1.length-3]);
        // sorts subarray form index 2 to 7
        // Arrays.sort(a, 2, 7);
    }
}
