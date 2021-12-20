package com.androidapps.basic.javacollection;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapInterface {
    public static void main(String[] args) {
        NavigableMapInterface obj=new NavigableMapInterface();
        obj.methods();
    }

    private void methods() {
        NavigableMap<String,String> original = new TreeMap<>();
        original.put("1", "one");
        original.put("2", "two");
        original.put("3", "three");
        original.put("4", "four");
        original.put("5", "five");
        original.put("6", "six");

        System.out.println("firstKey = " + original.firstKey());
        System.out.println("lastKey = " + original.lastKey());
        System.out.println("firstEntry = " + original.firstEntry());
        System.out.println("lastEntry = " + original.lastEntry());
        System.out.println("ceilingKey = " + original.ceilingKey("3"));
        System.out.println("ceilingEntry = " + original.ceilingEntry("3"));
        System.out.println("floorKey = " + original.floorKey("3"));
        System.out.println("floorEntry = " + original.floorEntry("3"));
        System.out.println("higherKey = " + original.higherKey("3"));
        System.out.println("lowerKey = " + original.lowerKey("3"));
        System.out.println("pollFirstEntry = " + original.pollFirstEntry());
        System.out.println("pollLastEntry = " + original.pollLastEntry());
        System.out.println("headMap = " + original.headMap("3"));
        System.out.println("headMapInculsive = " + original.headMap("3",true));
        System.out.println("tailMap = " + original.tailMap("3"));
        System.out.println("tailMapInculsive = " + original.tailMap("3",false));
        System.out.println("subMap = " + original.subMap("3","5"));
        System.out.println("subMapInculsive = " + original.subMap("3",true,"6",false));


    }
}
