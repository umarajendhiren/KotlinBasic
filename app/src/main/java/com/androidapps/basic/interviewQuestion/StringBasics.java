package com.androidapps.basic.interviewQuestion;

import java.util.Arrays;

public class StringBasics {
    static String string1 = "Hai there";
    static String str = "He said, 'The mailman loves you.' I heard it with my own ears.";
    static int charCount = 0;
    static int spaceCount = 0;
    static int vowelsCount = 0;
    static int consonantCount = 0;
    static int punctuationCount = 0;

    public static void main(String[] args) {

        // CountNumberOfCharecterInString();
        // vowelsAndConsonant();
        // countTotalPunctuations();
        //isGivenStringAnagram();
        // DivideStringEqualParts();
        //AllSubSetOfString();
        // findAllSubstring();

        //repalceSpaceWithChar();
        //removeSpaceinSentence();

        // findLengthOfStringwithoutLengthMethod();
       // findLengthOfStringwithoutLengthMethod1();
        
        findocuuaranceOfCharactorUsingLoop("uma");
        findocuuaranceOfCharactorUsingForEachLoop("uma");


    }

    private static void findocuuaranceOfCharactorUsingForEachLoop(String input) {
        //a more elegant way of counting occurrence of character in String using foreach loop

        charCount = 0; //resetting character count
        for(char ch: input.toCharArray()){
            if(ch == 'a'){
                charCount++;
            }
        }
        System.out.println(charCount);

    }

    private static void findocuuaranceOfCharactorUsingLoop(String input) {
        //counting occurrence of character with loop
        int charCount = 0;
        for(int i =0 ; i<input.length(); i++){
            if(input.charAt(i) == 'a'){
                charCount++;
            }
        }
        System.out.println(charCount);
    }



    private static void findLengthOfStringwithoutLengthMethod1() {
/*Logic
Initialize i with 0 and iterate over String without specifying any condition. So it will be always true.
Once value of i will be more than length of String, it will throw StringIndexOutOfBoundsException exception.
We will catch the exception and return i after coming out of catch block.*/
        String str = "hi";
        int i = 0;
        try {
            for (i = 0; ; i++) {
                str.charAt(i);
            }

        } catch (Exception e) {
            System.out.println("length of string " + i);
        }

    }

    private static void findLengthOfStringwithoutLengthMethod() {

      /*Logic
      Convert string to char array using toCharArray method
      Iterate over char array and incrementing length variable.*/
        String str = "This is hello world";
        //System.out.println("length of helloWorld string :"+getLengthOfStringWithCharArray(helloWorld));


        int length = 0;
        char[] strCharArray = str.toCharArray();
        for (char c : strCharArray) {
            length++;
        }
        System.out.println("length of string " + length);
    }


    private static void removeSpaceinSentence() {
        String string = "Once in a blue moon";
        //string=string.replace(" ","");

        string = string.replaceAll("\\s+", "");
        System.out.println("removeSpaceinSentence = " + string);


    }

    private static void repalceSpaceWithChar() {
        String string = "Once in a blue moon";
        char ch = '+';

        //Replace space with specific character ch
        string = string.replace(' ', ch);

        System.out.println("String after replacing spaces with given character: ");
        System.out.println(string);
    }

    private static void AllSubSetOfString() {
       /* In this program, all the subsets of the string need to be printed. The subset of a string is the character or the group of characters that are present inside the string.

                All the possible subsets for a string will be n(n+1)/2.

        For example, all possible subsets of a string "FUN" will be F, U, N, FU, UN, FUN.*/

        String str = "abbc";
        int len = str.length();
        int temp = 0;
        //Total possible subsets for string of size n is n*(n+1)/2
        String arr[] = new String[len * (len + 1) / 2];

        //This loop maintains the starting character
        for (int i = 0; i < len; i++) {
            //This loop adds the next character every iteration for the subset to form and add it to the array
            for (int j = i; j < len; j++) {
                arr[temp] = str.substring(i, j + 1);
                temp++;
            }
        }

        //This loop prints all the subsets formed from the string.
        System.out.println("All subsets for given string are: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    private static void DivideStringEqualParts() {
/*Here, our task is to divide the string S into n equal parts. We will print an error message if the string cannot be divisible into n equal parts otherwise all the parts need to be printed as the output of the program.

To check whether the string can be divided into N equal parts, we need to divide the length of the string by n and assign the result to variable chars.

If the char comes out to be a floating point value, we can't divide the string otherwise run for loop to traverse the string and divide the string at every chars interval.*/
        String str = "aaaabbbbcccc";

        //Stores the length of the string
        int len = str.length();
        //n determines the variable that divide the string in 'n' equal parts
        int n = 3;
        int temp = 0, chars = len / n;
        //Stores the array of string
        String[] equalStr = new String[n];
        //Check whether a string can be divided into n equal parts
        if (len % n != 0) {
            System.out.println("Sorry this string cannot be divided into " + n + " equal parts.");
        } else {
            for (int i = 0; i < len; i = i + chars) {
                //Dividing string in n equal part using substring()
                String part = str.substring(i, i + chars);
                equalStr[temp] = part;
                temp++;
            }
            System.out.println(n + " equal parts of given string are ");
            for (int i = 0; i < equalStr.length; i++) {
                System.out.println(equalStr[i]);
            }
        }

    }

    private static void isGivenStringAnagram() {

        String str1 = "Brag";
        String str2 = "Grab";

        //Converting both the string to lower case.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        //Checking for the length of strings
        if (str1.length() != str2.length()) {
            System.out.println("Both the strings are not anagram");
        } else {
            //Converting both the arrays to character array
            char[] string1 = str1.toCharArray();
            char[] string2 = str2.toCharArray();

            //Sorting the arrays using in-built function sort ()
            Arrays.sort(string1);
            Arrays.sort(string2);

            //Comparing both the arrays using in-built function equals ()
            if (Arrays.equals(string1, string2) == true) {
                System.out.println("Both the strings are anagram");
            } else {
                System.out.println("Both the strings are not anagram");
            }
        }

    }

    private static void countTotalPunctuations() {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.' ||
                    str.charAt(i) == ',' ||
                    str.charAt(i) == ':' ||
                    str.charAt(i) == ';' ||
                    str.charAt(i) == '!' ||
                    str.charAt(i) == '?' ||
                    str.charAt(i) == '\'' ||
                    str.charAt(i) == '\"') {
                punctuationCount++;
            }
        }
        System.out.println("punctuationCount = " + punctuationCount);
    }

    private static void vowelsAndConsonant() {
        String lowerCaseString = string1.toLowerCase();
        for (int i = 0; i < lowerCaseString.length(); i++) {
            if (lowerCaseString.charAt(i) == 'a' ||
                    lowerCaseString.charAt(i) == 'e' ||
                    lowerCaseString.charAt(i) == 'i' ||
                    lowerCaseString.charAt(i) == 'o' ||
                    lowerCaseString.charAt(i) == 'u') {
                vowelsCount++;
            } else if (lowerCaseString.charAt(i) >= 'a' && lowerCaseString.charAt(i) <= 'z') {
                consonantCount++;
            }

        }
        System.out.println("vowelsCount = " + vowelsCount);
        System.out.println("consonantCount = " + consonantCount);
    }

    private static void CountNumberOfCharecterInString() {
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != ' ') {
                charCount++;
            } else if (string1.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        System.out.println("totalChar = " + charCount);
        System.out.println("totalspace = " + spaceCount);
    }

    public static void findAllSubstring() {
        String str = "abbc";
        System.out.println("All substring of abbc are:");
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));

            }
        }
    }
}
