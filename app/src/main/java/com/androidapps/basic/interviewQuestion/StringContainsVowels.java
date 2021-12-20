package com.androidapps.basic.interviewQuestion;

public class StringContainsVowels {
    public static void main(String[] args) {
        System.out.println("isStringContainsVowels "+isStringContainsVowels("uma"));;
        System.out.println("isStringContainsVowels "+isStringContainsVowels("nqm"));;
    }

    private static boolean isStringContainsVowels(String input) {
       return input.toString().trim().toLowerCase().matches(".*[aeiou].*");


    }
}
