package com.androidapps.basic.interviewQuestion;

public class ConvertStringToLong {
    public static void main(String[] args) {
       StringTolong();
       longToString();
    }

    private static void longToString() {
        /*We can convert long to String in java using String.valueOf() and Long.toString() methods.
        *The Long.toString() is the static method of Long class
        * the String.valueOf() is the static method of String class */
        long i=9993939399L;//L is the suffix for long
        String s=String.valueOf(i);
        System.out.println(s);//Now it will return "9993939399"


        long i1=9993939399L;
        String s1=Long.toString(i1);
        System.out.println(s1);
    }

    private static void StringTolong() {
        /*We can convert String to long in java using Long.parseLong() method.
         * The parseLong() is the static method of Long class.*/
        String s="9990449935";
        long l=Long.parseLong(s);
        System.out.println(l);
    }
}
