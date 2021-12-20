package com.androidapps.basic.interviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicateElement {
    public static int removeDuplicateElements(int arr[], int n){
        if (n==0 || n==1){
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        // Changing original array
        for (int i=0; i<j; i++){
            arr[i] = temp[i];
        }
        return j;
    }

    public static void ReomveDuplicateUsingHashSet(){
        //ArrayList with duplicates String
        List<String> duplicateList = (List<String>) Arrays.asList("Android" , "Android", "iOS", "Windows mobile");

        //should print 4 becaues of duplicates Android
        System.out.println("size of Arraylist with duplicates: " + duplicateList.size());
        System.out.println("ArrayList with duplicates: " + duplicateList);

        //Converting ArrayList to HashSet to remove duplicates
        LinkedHashSet<String> listToSet = new LinkedHashSet<String>(duplicateList);

        //Creating Arraylist without duplicate values
        List<String> listWithoutDuplicates = new ArrayList<String>(listToSet);

        //should print 3 becaues of duplicates Android removed
        System.out.println("size of ArrayList without duplicates: " + listToSet.size());
        System.out.println("ArrayList after removing duplicates in same order: " + listWithoutDuplicates);


    }





    public static void main (String[] args) {

        //Write a Program remove duplicates from an array without using Collection API(hashSet)?

        int arr[] = {10,20,20,30,30,40,50,50};
        int length = arr.length;
        length = removeDuplicateElements(arr, length);
        //printing array elements
        for (int i=0; i<length; i++)
            System.out.print(arr[i]+" ");

        ReomveDuplicateUsingHashSet();
    }


}
