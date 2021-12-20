package com.androidapps.basic.interviewQuestion;

public class StringDuplicateWordInString {

    public static void main(String[] args) {
        duplicateWordInString();
    }
    public static void duplicateWordInString() {

        String string = "Big black bug bit a big black dog on his big black nose";

        String[] str = string.split(" ");

        int count = 0;

        System.out.println("Duplicate word in a given string: ");


        for(int i = 0; i < str.length; i++) {
            count = 1;
            for(int j = i+1; j < str.length; j++) {
                if(str[i].equals(str[j])) {
                    count++;
                    //Set words[j] to 0 to avoid printing visited word
                    str[j] = "0";
                }
            }

            //Displays the duplicate word if count is greater than 1
            if(count > 1 && str[i] != "0")
                System.out.println(str[i]);
        }
    }
}
