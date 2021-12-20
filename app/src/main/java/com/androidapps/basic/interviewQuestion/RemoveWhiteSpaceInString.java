package com.androidapps.basic.interviewQuestion;

public class RemoveWhiteSpaceInString {
    public static void main(String[] args) {
          RemoveWhiteSpace(" a b c ");
       // RemoveWhiteSpaceUsingStrip(" a b c ");


    }

    private static void RemoveWhiteSpaceUsingStrip(String s) {

        //strip() method added in java 11.for older version need to use trim()
        //internally strip()  method uses isWhiteSpace() to remove whiteSpace in given string.
      /* String trimmedString=s.trim();
        System.out.println("s = " + trimmedString);
        System.out.println("s = " + trimmedString.length());*/


        /*String strip() – returns a string whose value is given string, with all leading and trailing white space removed. Please note that String.trim() method also produces the same result.
String stripLeading() – returns a string whose value is given string, with all leading white space removed.
String stripTrailing() – returns a string whose value is given string, with all trailing white space removed.*/

      /*  String str = "  Hello World !!   ";

        System.out.println( str.strip() );          //"Hello World !!"

        System.out.println( str.stripLeading() );   //"Hello World !!   "

        System.out.println( str.stripTrailing() );  //"  Hello World !!"*/
    }

    private static void RemoveWhiteSpace(String s) {
        StringBuilder output = new StringBuilder();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (!Character.isWhitespace(c)) {
                output.append(c);
            }
        }
        System.out.println("StringWithOutWhiteSpace " + output);
    }
}
