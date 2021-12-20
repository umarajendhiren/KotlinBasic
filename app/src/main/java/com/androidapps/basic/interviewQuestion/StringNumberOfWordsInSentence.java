package com.androidapps.basic.interviewQuestion;

public class StringNumberOfWordsInSentence {
    public static void main(String[] args) {
        String str="this is uma rajendhiren";
        String[] strings=str.split(" ");
        System.out.println(
                "Number Of Words are "+strings.length
        );
    }
}
