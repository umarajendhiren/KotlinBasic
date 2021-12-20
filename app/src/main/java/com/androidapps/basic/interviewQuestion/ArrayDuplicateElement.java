package com.androidapps.basic.interviewQuestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDuplicateElement {

    public static void main(String[] args) {

        //Initialize array
        int[] arr = new int[]{1, 2, 3, 4, 2, 7, 8, 8, 3};
        System.out.println("Duplicate elements in given array: ");
        //Searches for duplicate element
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    System.out.println(arr[j]);
            }

        }

        String[] withDuplicates = new String[]{"one", "two", "three", "one"};
        String[] withoutDuplicates = new String[]{"one", "two", "three"};

        System.out.println("Checking array with duplicate using brute force: " + bruteforce(withDuplicates));
        System.out.println("Checking array without any duplicate using brute force: " + bruteforce(withoutDuplicates));

        System.out.println("Checking array with duplicate using Set and List: " + checkDuplicateUsingSet(withDuplicates));
        System.out.println("Checking array without any duplicate using Set and List: " + checkDuplicateUsingSet(withoutDuplicates));


        System.out.println("Checking array with duplicate using Set and List: " + checkDuplicateUsingAdd(withDuplicates));
        System.out.println("Checking array without any duplicate using Set and List: " + checkDuplicateUsingAdd(withoutDuplicates));


    }

    /*
     * brute force way of checking if array contains duplicates in Java
     * comparing each element to all other elements of array
     * complexity on order of O(n^2) not advised in production
     */
    public static boolean bruteforce(String[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i].equals(input[j]) && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * detect duplicate in array by comparing size
ADVERTISEMENT

 of List and Set
     * since Set doesn't contain duplicate, size must be less for an array which contains duplicates
     */
    public static boolean checkDuplicateUsingSet(String[] input) {
        List<String> inputList = Arrays.asList(input);
        Set<String> inputSet = new HashSet(inputList);
        if (inputSet.size() < inputList.size())
            return true;

        return false;
}

    /*
     * Since Set doesn't allow duplicates add() return false
     * if we try to add duplicates into Set and this property
     * can be used to check if the array contains duplicates in Java
     */
    public static boolean checkDuplicateUsingAdd(String[] input) {
        Set<String> tempSet = new HashSet<>();
        for (String str : input) {
            if (!tempSet.add(str)) {
                return true;
            }
        }
        return false;
    }
}

