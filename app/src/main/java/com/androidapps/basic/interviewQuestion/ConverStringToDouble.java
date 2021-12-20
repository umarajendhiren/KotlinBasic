package com.androidapps.basic.interviewQuestion;

public class ConverStringToDouble {
    public static void main(String[] args) {
        StringToDuble();
        doubleToString();
        
    }

    private static void doubleToString() {
        double d=23.6;
        String s=String.valueOf(d);
        System.out.println(s);

        String s1=Double.toString(d);
        System.out.println(s1);
    }

    private static void StringToDuble() {
        //We can convert String to double in java using Double.parseDouble() method.
        String s="23.6";
        double d=Double.parseDouble("23.6");
        System.out.println(d);
    }
}
