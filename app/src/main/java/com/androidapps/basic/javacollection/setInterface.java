package com.androidapps.basic.javacollection;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class setInterface {


    private Set<String> set1;
    private Set<String> set2;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public static void main(String[] args) {

        setInterface setInterface=new setInterface();
        setInterface.AddElementToSet1();
        setInterface.AddElementToSet2();
        setInterface.AddElementToSet3();

        //setInterface.removeElement();

        //setInterface.retainAll();
        //setInterface.checkSetIsEmpty();
        //setInterface.checkSetContainsElement();
        //setInterface.converSetToList();



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void converSetToList() {
        List<String> list=new ArrayList<>();
        list.addAll(set1);
        set1.forEach((element)-> System.out.println("listelement = " + element));

    }

    private void checkSetContainsElement() {
        boolean isContainOne=set1.contains("1");
        boolean isContainSet2=set1.containsAll(set2);

        System.out.println("isContainOne = " + isContainOne);

        System.out.println("isContainSet2 = " + isContainSet2);

        set1.add(null);
        System.out.println("isContainNull = " + set1.contains(null));
    }

    private void checkSetIsEmpty() {
        boolean isSetEmpty=set1.isEmpty();
        if(!isSetEmpty){

            System.out.println("setSize = " + set1.size());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void retainAll() {
        set1.retainAll(set2);
        set1.forEach((element)-> System.out.println("RetainedELEMENT = " + element));

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void removeElement() {
        set1.remove("1");
        set1.removeAll(set2);
        set1.forEach((element)-> System.out.println("AfterelementRemoved = " + element));
        set1.clear();


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void AddElementToSet3() {
        set1.addAll(set2);
        set1.forEach((element)-> System.out.println("Alladdedelement = " + element));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void AddElementToSet2() {
         set1=new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.forEach((element)-> System.out.println("addedelement = " + element));

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void AddElementToSet1() {

        //Set allows 0 element 
       // Set setElementUsinfOf=Set.of();

        set2=Set.of("3","4","5","6");
        set2.forEach((element)-> System.out.println("element = " + element));
    }
}
