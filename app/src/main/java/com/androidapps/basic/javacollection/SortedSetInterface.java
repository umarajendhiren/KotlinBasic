package com.androidapps.basic.javacollection;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetInterface {

    //this interface subtype of Set interface .
    //this interface is implementation of TreeSet.if we want to use this interface we  must use implementation of this interface .
    //it exactly behave like Set interface except it store the element in sorted order. by default ascending order.

    SortedSet<String> sortedSet=new TreeSet<>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        SortedSetInterface obj=new SortedSetInterface();
        obj.initiateSortedSet();

        obj.getFirstElement();
        obj.getLastElement();
        obj.getHeadSet();
        obj.getTailSet();
        obj.getSubSet();
        obj.SortInDescendingOrder();
        obj.removeElement();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void removeElement() {
        sortedSet.remove("a");
        sortedSet.forEach((element)-> System.out.println("afterRemoved = " + element));
    }

    private void SortInDescendingOrder() {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("one");
        treeSet.add("two");
        treeSet.add("three");
        Iterator<String> iterator=treeSet.descendingIterator();
        while (iterator.hasNext()){

            System.out.println("iterator.next() = " + iterator.next());
        }
    }

    private void getSubSet() {
        System.out.println("subSet = " + sortedSet.subSet("c","e"));
    }

    private void getTailSet() {
        System.out.println("tailSet = " + sortedSet.tailSet("c"));
    }

    private void getHeadSet() {
        System.out.println("headSet = " + sortedSet.headSet("c"));
    }

    private void getLastElement() {
        System.out.println("sortedSet.last() = " + sortedSet.last());
    }

    private void getFirstElement() {
        System.out.println("sortedSet.first() = " + sortedSet.first());
    }

    private void initiateSortedSet() {
        sortedSet.add("a");
        sortedSet.add("b");
        sortedSet.add("c");
        sortedSet.add("d");
        sortedSet.add("e");
    }

}
