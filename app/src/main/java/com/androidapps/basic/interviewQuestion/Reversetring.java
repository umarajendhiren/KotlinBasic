package com.androidapps.basic.interviewQuestion;

import java.util.Arrays;

public class Reversetring {
    public static void main(String[] args) {
        //  System.out.println("reversed String " +ReverseTheString("uma"));
        // ReverseTheString1("kauthik");
        System.out.println(reverseStringWordByWord("this is uma"));
    }

    private static String ReverseTheString(String input) {

        if (input == null || input.trim().isEmpty())
            return "invalid input";
        char[] characters = input.toCharArray();
        System.out.println("characters = " + characters);

        StringBuilder output = new StringBuilder();

        for (int i = characters.length - 1; i >= 0; i--) {

            output.append(characters[i]);

        }
        return output.toString();
    }

    private static void ReverseTheString1(String input) {
        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
    }

    public static String reverseStringWordByWord(String s) {
        if (s.isEmpty())                            //checks the string if empty
            return s;
        return reverseStringWordByWord(s.substring(1)) + s.charAt(0);                     //recursively called function
    }


    public static void reverseStringUsingAcollectionApiMethod() {
        //import org.apache.commons.lang.ArrayUtils;
        int[] iArray = new int[]{101, 102, 103, 104, 105};
        String[] sArray = new String[]{"one", "two", "three", "four", "five"}; // reverse int array using Apache commons  ArrayUtils.reverse() method.

        System.out.println("Original int array : " + Arrays.toString(iArray));
        //ArrayUtils.reverse(iArray);
        System.out.println("reversed int array : " + Arrays.toString(iArray)); // reverse String array using ArrayUtis class System.out.println("Original String array : " + Arrays.toString(sArray)); ArrayUtils.reverse(sArray); System.out.println("reversed String array in Java : " + Arrays.toString(sArray));


    }
}
