package com.androidapps.basic.interviewQuestion;

import java.util.HashSet;
import java.util.Set;

public class StringPermutationOfString {
    public static void main(String[] args) {

        /*Set<String> set=permutationOfString("ABC");
        System.out.println("Permutations of String ABC are:");
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);*/

        String s = "abb";
        printPermutn(s, "");
        }

    // Java program to print all the permutations
// of the given string


        // Function to print all the permutations of str
        static void printPermutn(String str, String ans)
        {

            // If string is empty
            if (str.length() == 0) {
                System.out.print(ans + " ");
                return;
            }

            for (int i = 0; i < str.length(); i++) {

                // ith character of str
                char ch = str.charAt(i);

                // Rest of the string after excluding
                // the ith character
                String ros = str.substring(0, i) +
                        str.substring(i + 1);

                // Recurvise call
                printPermutn(ros, ans+ch);
            }
        }





    public static Set<String> permutationOfString(String str)
    {
        Set<String> permutationSet=new HashSet<>();

        if(str.length()==0)
        {
            permutationSet.add("");
            return permutationSet;
        }

        // take out first character of String
        char c=str.charAt(0);
        // Remaining String
        String rem=str.substring(1);

        Set<String> permutatedSetForRemainingString=permutationOfString(rem);
        for (String permutedString: permutatedSetForRemainingString) {
            for (int j = 0; j <= permutedString.length(); j++) {
                String permutation=insertFirstCharAtDiffPlaces(permutedString,c,j);
                permutationSet.add(permutation);
            }

        }
        return permutationSet;

    }
    public static String insertFirstCharAtDiffPlaces(String perm,char firstChar,int index)
    {
        // Inserting firstCharacter of orig String at difference places based on index
        return perm.substring(0,index)+firstChar+perm.substring(index);
    }

}
