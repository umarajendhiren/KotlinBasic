package com.androidapps.basic.interviewQuestion;

import java.util.Scanner;

public class AscIIValueForChar {
/*ASCII acronym for American Standard Code for Information Interchange. It is a 7-bit character set contains 128 (0 to 127) characters.
It represents the numerical value of a character. For example, the ASCII value of A is 65.*/
    public static void main(String[] args) {
        // AllValue();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number to find charector");
        int enteredNumber=scanner.nextInt();
        char charec=(char) enteredNumber;
        System.out.println("Ascii value for "+enteredNumber+" =" + charec);
        }

    private static void AllValue() {
        for(int i=0;i<=128;i++){
            System.out.println("Ascii value for "+(char)i +"=" + i);
            //A-Z 65 to 90
            //a-z 97-122
    }
}
}
