package com.androidapps.basic.interviewQuestion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraySearchElement {


        @RequiresApi(api = Build.VERSION_CODES.N)
        public static void main(String[] args) {
            int arr[]={16,19,21,25,3,5,8,10};
            System.out.println("Index of element 5 : "+findElementRotatedSortedArray(arr,0,arr.length-1,5));
            
            //using linear search
            //usingLinearSearch();
            //UsingListcontainsMethod();
           // UsingInputStreamOf();

            Integer[] array=new Integer[]{16,19,21,25,3,5,8,10};
           System.out.println("is 25 exist? "+ isExists(array,25));
           System.out.println("is 25 contains? "+ contains(array,25));

            String[] stringarray=new String[]{"uma","kauthik","ashok"};
            System.out.println("is kauthik exist? "+ isExists(stringarray,"kauthik"));
            System.out.println("is ashok contains? "+ contains(stringarray,"ashok"));

            
        }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void UsingInputStreamOf() {

        // Get the array
        int[] arr=new int[]{ 5, 1, 1, 9, 7, 2, 6, 10 };

        // Get the value to be checked
        int toCheckValue = 7;

        boolean test
                = IntStream.of(arr)
                .anyMatch(x -> x == toCheckValue);

        // Print the result
        System.out.println("Is " + toCheckValue
                + " present in the array: " + test);
    }

    private static void UsingListcontainsMethod() {
        // check if the specified element
        // is present in the array or not
        // using contains() method

        // Get the array
        int[] arr=new int[]{ 5, 1, 1, 9, 7, 2, 6, 10 };

        // Get the value to be checked
        int toCheckValue = 7;

        // Print the array
        System.out.println("Array: "
                + Arrays.toString(arr));

        boolean test
                = Arrays.asList(arr)
                .contains(toCheckValue);

        // Print the result
        System.out.println("Is " + toCheckValue
                + " present in the array: " + test);


    }

    private static void usingLinearSearch() {

        // Get the array
        //int arr[] = { 5, 1, 1, 9, 7, 2, 6, 10 };
        int[] arr=new int[]{ 5, 1, 1, 9, 7, 2, 6, 10 };

        // Get the value to be checked
        int toCheckValue = 7;

        // Print the array
        System.out.println("Array: "
                + Arrays.toString(arr));




        // check if the specified element
        // is present in the array or not
        // using Linear Search method
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }

        // Print the result
        System.out.println("Is " + toCheckValue
                + " present in the array: " + test);
    }

    /** * Function to test if Array contains a certain value or not.
     *  * This method take advantage of * contains() method of ArrayList class, by converting array to ArrayList.
     *  * * @return true if array contains */
    public static <T> boolean isExists(final T[] array, final T object)
    { return Arrays.asList(array).contains(object); }


    /**
     * Another method to search an item in Java array.
     * This method loop through array and use
     * equals() method to search element. This actually performs
     * a linear search over array in Java
     *
     *@return true if array has provided value.
     */
    public static <T> boolean contains(final T[] array, final T v) {
        for (final T e : array) {
            if (e == v || v != null && v.equals(e)) {
                return true;
            }
        }

        return false;
    }


    public  static  int findElementRotatedSortedArray(int[] arr,int low,int high,int number)
        {
            int mid;
            while(low<=high)
            {
                mid=low + ((high - low) / 2);;

                if(arr[mid]==number)
                {
                    return mid;
                }
                if(arr[mid]<=arr[high])
                {
                    // Right part is sorted
                    if(number > arr[mid] && number <=arr[high])
                    {
                        low=mid+1;
                    }
                    else
                    {
                        high=mid-1;
                    }
                }
                else
                {
                    // Left part is sorted
                    if(arr[low]<=number && number < arr[mid])
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                }
            }
            return -1;
        }

}
