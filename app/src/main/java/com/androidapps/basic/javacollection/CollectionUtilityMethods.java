package com.androidapps.basic.javacollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtilityMethods {

    List<String> list = new ArrayList<>();
    List<String> destinationList = new ArrayList<>();


    public static void main(String[] args) {
        CollectionUtilityMethods obj = new CollectionUtilityMethods();
        obj.initiatelIst();

        // obj.addAll();
        // obj.replaceAll();
        //obj.copy();
        //obj.binarySearch();
        //obj.sort();
        // obj.reverse();
        //obj.shuffleList();
        //obj.minimum();
        // obj.maximum();


       // obj.unModifiableList();
    }

    private void unModifiableList() {

        //this method creates read-only set from given set .if we try to modify this set, will throw UnsupportedOperationException.
        Set<String> normalSet = new HashSet<>();
        normalSet.add("old value");
        Set<String> immutableSet = Collections.unmodifiableSet(normalSet);
        System.out.println("oldvalue " + immutableSet.contains("old value"));
        immutableSet.add("new value");
    }

    private void replaceAll() {
        //this method replace old value with new value,
        //this method uses equals() method to find old value.
        Collections.replaceAll(list, "one", "two");
        for (String listElement : list) {
            System.out.println("after replace " + listElement);
        }

    }

    private void maximum() {
        String maximum = Collections.max(list);
        System.out.println("maxi " + maximum);
    }

    private void minimum() {
        String minimum = Collections.min(list);
        System.out.println("mini " + minimum);


    }

    private void shuffleList() {
        //shuffle the element in list.
        Collections.shuffle(list);
        for (String listElement : list) {
            System.out.println("shuffled list " + listElement);
        }
    }

    private void addAll() {
        Collections.addAll(list, "6", "7");
        for (String listElement : list) {
            System.out.println("addAll = " + listElement);
        }
    }

    private void reverse() {
        //reverse the element in list
        Collections.reverse(list);
        for (String listElement : list) {
            System.out.println("listElement = " + listElement);
        }
    }

    private void copy() {

        //copy method copy the source list element and put that in destination list.for that destination list size must be same as source list.
        //if destination list has less size than source list, will throw IndexOutOfBoundsException.
        //if destination list has more element  than source list ,copy method replace all element in destination as in source and remaining element will be in same place.
        //if source is 1,2,3 and destination is 4,5,6,7 after copy output will be 1,2,3,7

        destinationList.add("1");
        destinationList.add("2");
        destinationList.add("3");
        destinationList.add("4");
        destinationList.add("5");
        destinationList.add("6");
        destinationList.add("7");

        Collections.copy(destinationList, list);
        System.out.println("indexOffive " + destinationList);
    }

    private void binarySearch() {
        //this method uses binary search algorithm .using this we can search particular element in list
        // and will give index of search element.
        //we need to give sorted(ascending) list as parameter when call this method.
        //if two same element presents in list,result will be not guaranteed.
        Collections.sort(list);
        for (String listElement : list) {
            System.out.println("sorted = " + listElement);
        }
        int index = Collections.binarySearch(list, "five");

        System.out.println("indexOffive " + index);
    }

    private void initiatelIst() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
    }
}
