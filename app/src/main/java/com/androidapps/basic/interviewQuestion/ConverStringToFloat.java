package com.androidapps.basic.interviewQuestion;

public class ConverStringToFloat {
    public static void main(String[] args) {
      StringToFloat();
      FloatToString();
    }

    private static void FloatToString() {
        /*We can convert float to String in java using String.valueOf() and Float.toString() methods.*/
        float f=12.3F;//F is the suffix for float
        String s=String.valueOf(f);
        System.out.println(s);

        String s1=Float.toString(f);
        System.out.println(s1);
    }

    private static void StringToFloat() {
        /*We can convert String to float in java using Float.parseFloat() method.*/
        String s="23";
        float f=Float.parseFloat(s);
        System.out.println(f);
    }
}
