package com.androidapps.basic.interviewQuestion;

import java.util.Scanner;

public class checkPolyndromeNumber {
   /* public static void main(String[] args) {
        int r,sum=0,temp;
        int n=454;//It is the number variable to be checked for palindrome

        temp=n;
        while(n>0){
            r=n%10;  //getting remainder
            sum=(sum*10)+r;
            n=n/10;
        }
        if(temp==sum)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");
    }*/

    public static void main(String []args){
        String original,reverse="";

        Scanner in=new Scanner(System.in);

        System.out.println("Enter srting/number to find isPalindrome");
        original=in.nextLine();
        int length=original.length();
        for(int i=length-1;i>=0;i--){
            reverse=reverse+original.charAt(i);
        }

        if(reverse.equals(original))
            System.out.println("palindrom");

        else
            System.out.println("not palindrome");

    }

}

