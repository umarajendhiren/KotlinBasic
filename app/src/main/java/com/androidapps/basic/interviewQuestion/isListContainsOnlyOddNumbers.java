package com.androidapps.basic.interviewQuestion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class isListContainsOnlyOddNumbers {

    static List<Integer> integerList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        integerList = Arrays.asList(1, 3, 5, 7, 8);
        //System.out.println(listContainsonlyOddNumbers(integerList));

        if (onlyOddNumbers(integerList)) {

            System.out.println("list contains even element");

        } else System.out.println("list only contains odd element");


    }

    //if list contains more element this is not time efficient method because each time for-each loop get element from list using iterator internally .
    public static boolean listContainsonlyOddNumbers(List<Integer> list) {
        for (int i : list) {
            if (i % 2 == 0)
                return false;
        }
        return true;
    }

    //this stream method is faster than for-each loop

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean onlyOddNumbers(List<Integer> list) {

        return list.parallelStream() // parallel stream for faster processing
                .anyMatch(x -> x % 2 == 0); // return as soon as any elements match the condition
    }


}
