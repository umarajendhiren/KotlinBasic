package com.androidapps.basic.interviewQuestion;

public class checkPalindromeString {

    /*A palindrome string is one whose reverse is also the same string.
    So we can reverse the input string and check if both strings are equal or not.
     We can also use the String charAt(int index) method to check for palindrome string.*/

    /*Palindrome number in java: A palindrome number is a number that is same after reverse.
     For example 545, 151, 34543, 343, 171, 48984 are the palindrome numbers. It can also be a string like LOL, MADAM etc.*/
    static String givenString;

    public static void main(String[] args) {
        //System.out.println(isPalindrom("aba"));

        System.out.println(reverseString("dabad"));
        String reversedString = reverseString("dabad");

        if (givenString.equals(reversedString)) {

            System.out.println("given string is palindrome");
        } else {

            System.out.println("given string is not palindrome");
        }


    }


    public static boolean isPalindrom(String n) {

        for (int i = 0; i < n.length() / 2; i++) {

            if (n.charAt(i) != n.charAt(n.length() - i - 1))
                return false;
        }
        return true;

    }

    public static String reverseString(String n) {
        givenString = n;

        StringBuilder reversedString = new StringBuilder();

        char[] charecters = n.toCharArray();

        for (int i = n.length() - 1; i >= 0; i--) {

            reversedString.append(charecters[i]);

        }

        return reversedString.toString();
    }
}