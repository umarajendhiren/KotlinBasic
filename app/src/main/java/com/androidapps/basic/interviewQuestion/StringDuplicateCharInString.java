package com.androidapps.basic.interviewQuestion;

import java.util.HashMap;

public class StringDuplicateCharInString {
    public static void main(String[] args) {
        String string1 = "Great responsibility";
        int count;

        //Converts given string into character array
        char string[] = string1.toCharArray();

        System.out.println("Duplicate characters in a given string: ");
        //Counts each character present in the string
        for (int i = 0; i < string.length; i++) {
            count = 1;
            for (int j = i + 1; j < string.length; j++) {
                if (string[i] == string[j] && string[i] != ' ') {
                    count++;
                    //Set string[j] to 0 to avoid printing visited character
                    string[j] = '0';
                }
            }
            //A character is considered as duplicate if count is greater than 1
            if (count > 1 && string[i] != '0')
                System.out.println(string[i]);
        }
        findDuplicateCharInString();
    }

    public static void findDuplicateCharInString() {
        String str = "java2blog.com";
        HashMap<Character, Integer> charCountMap = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (charCountMap.containsKey(c)) {
                /*System.out.println("first repeated charecter "+c);
                break;*/
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }

        }
        for (Character c : charCountMap.keySet()) {
            if (charCountMap.get(c) > 1)
                System.out.println("duplicate character : " + c + " ====== " + " count : " + charCountMap.get(c));

        }


    }

}




