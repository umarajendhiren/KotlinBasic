package com.androidapps.basic.interviewQuestion;

public class ConvertStringToInt {
    public static void main(String[] args) {
        //StringToInt();
        convertIntToString();
    }

    private static void convertIntToString() {
        /*We can convert int to String in java using String.valueOf() and Integer.toString() methods.
        Alternatively, we can use String.format() method, string concatenation operator etc.
        The valueOf() is the static method of String class
        The toString() is the static method of Integer class.*/
        int i=200;
        String s=String.valueOf(i);
        System.out.println(i+100);//300 because + is binary plus operator
        System.out.println(s+100);//200100 because + is string concatenation operator

        String s1=Integer.toString(i);
        System.out.println(i+100);//300 because + is binary plus operator
        System.out.println(s1+100);//200100 because + is string concatenation operator

        //The String.format() method is used to format given arguments into String.
        String s2=String.format("%d",i);
        System.out.println(s2);
    }

    private static void StringToInt() {
        /*we can use Integer.parseInt() to convert String to int .
         * To convert into Integer object ,we need to use Integer.valueOf()*/
        String age = "200";

        //Converting String into int using Integer.parseInt()
        int ag = Integer.parseInt(age);
        System.out.println("ag = " + ag);

        System.out.println("concati "+age+100);//200100, because "200"+100, here + is a string concatenation operator
        System.out.println("concatinate "+ag+100);//will give 200100 even if i use int value with string
        System.out.println(ag+100);//300, because 200+100, here + is a binary plus operator(both are int)

        //converting String into Integer using Integer.valueOf() method
        Integer i = Integer.valueOf(age);
        System.out.println("Integer object= " + i);

        /*If you don't have numbers in string literal, calling Integer.
        parseInt() or Integer.valueOf() methods throw NumberFormatException.*/
        String s="hello";
        int j=Integer.parseInt(s);
        System.out.println(j);
    }
}
