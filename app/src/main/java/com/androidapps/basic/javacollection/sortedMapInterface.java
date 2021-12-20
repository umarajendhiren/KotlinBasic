package com.androidapps.basic.javacollection;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class sortedMapInterface {

    //this is subtype of map interface , with the addition that the elements stored in a Java SortedMap map are sorted internally.
    // This means you can iterate the elements stored in a SortedMap in the sort order.

    //to use sorted map we need to use implementation of sorted map that is treemap

    public static void main(String[] args) {
        sortedMapInterface obj=new sortedMapInterface();
        obj.sortedInAscending();
        //obj.sortedInDesending();
    }

    private void sortedInDesending() {
        TreeMap<String,String> sortedMap = new TreeMap<>();
        sortedMap.put("c", "three");
        sortedMap.put("a", "one");
        sortedMap.put("b", "two");


        Iterator<String> iterator = sortedMap.descendingKeySet().iterator();

        while(iterator.hasNext()) {
            String key   = (String) iterator.next();

            String value = (String) sortedMap.get(key);
            System.out.println("value = " + value);
        }

    }

    private void sortedInAscending() {
        //default sorting order is ascending
        SortedMap<String,String> sortedMap = new TreeMap();
        sortedMap.put("c", "three");
        sortedMap.put("a", "one");
        sortedMap.put("b", "two");
        sortedMap.put("d", "four");
        sortedMap.put("e", "five");


        Iterator iterator = sortedMap.keySet().iterator();

        while(iterator.hasNext()) {
            String key   = (String) iterator.next();

            String value = (String) sortedMap.get(key);
            System.out.println("value = " + value);
        }


        System.out.println("first key = " + sortedMap.firstKey());
        System.out.println("last key = " + sortedMap.lastKey());
        System.out.println("headMap  = " + sortedMap.headMap("c"));
        System.out.println("tailMap  = " + sortedMap.tailMap("c"));
        System.out.println("subMap  = " + sortedMap.subMap("b","e"));


    }
}
