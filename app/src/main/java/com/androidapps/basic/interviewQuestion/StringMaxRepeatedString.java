package com.androidapps.basic.interviewQuestion;

public class StringMaxRepeatedString {
    public static void main(String[] args) {
        mostRepeatedWord();
    }
    public static void mostRepeatedWord(){

        String string = "Big black bug bit a big black dog on his big black nose black ";


      string= string.toLowerCase();
        String[] str = string.split(" ");
        int[] freq = new int[str.length];
        int count = 0;
        int maxCount=0;
        String macRepeatedWord="null";

        System.out.println("max repeated word in a given string: ");


        for(int i = 0; i < str.length; i++) {
            freq[i] = 1;
            for(int j = i+1; j < str.length; j++) {
                if(str[i].equals(str[j]) && str[i] != "0") {
                    freq[i]++;
                    //Set words[j] to 0 to avoid printing visited word
                    str[j] = "0";
                }
            }

            //Displays the duplicate word if count is greater than 1
            if(count > 1 && str[i] != "0")
                System.out.println(str[i]);

            /*maxCount=1;
            macRepeatedWord=str[0];*/

            if(maxCount<freq[i] && str[i] != "0"){

                maxCount=freq[i];
                macRepeatedWord=str[i];

            }
        }

        System.out.println(macRepeatedWord);
    }

}
