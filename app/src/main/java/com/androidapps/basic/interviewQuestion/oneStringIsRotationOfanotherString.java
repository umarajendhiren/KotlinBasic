package com.androidapps.basic.interviewQuestion;

public class oneStringIsRotationOfanotherString {
    public static void main(String[] args) {

        System.out.println(
                "java2blog and blogjava2 are rotation of each other : " + isRotation("java2blog", "blogjava2"));
        System.out.println(
                "java2blog and avablog2j are rotation of each other : " + isRotation("java2blog", "avablog2j"));


        System.out.println(
                "java2blog and blogjava2 are rotation of each other : " + checkRotatation("java2blog", "blogjava2"));

    }

    public static boolean isRotation(String str, String rotation) {
        String str2 = str + str;

        if (str2.contains(rotation)) {
            return true;
        }
        return false;

    }

    public static boolean checkRotatation(String original, String rotation) {
        if (original.length() != rotation.length()) {
            return false;
        }

        String concatenated = original + original;
        if (concatenated.indexOf(rotation) != -1) {
            return true;
        }
        return false;
    }
}


