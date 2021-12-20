package com.androidapps.basic.javacollection;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class iterator {

    //we can obtain iterator from any collection like from list or from set by calling iterator() method
    public List<String> myList = new ArrayList<>();
    Iterator<String> listIterator;

    public Set<String> mySet = new HashSet<>();
    Iterator<String> setIterator;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {


        iterator myClassInstance = new iterator();
        myClassInstance.initiateMyList();

        //when we iterate through list we will get same order of item in list.
        // for example if i have 1,2,3 iterator.next() will give 1,2,3 but in Set order of element is not guaranteed.

        //myClassInstance.printAllElementInList(myClassInstance.listIterator);

        //myClassInstance.modificationDuringIteration(myClassInstance.listIterator);

        //myClassInstance.removeElement(myClassInstance.listIterator);

       //myClassInstance.getAllElementInListUsingForEach();

       // myClassInstance.listIteratorForList();

        // myClassInstance.printAllElementInSet(myClassInstance.setIterator);


    }

    private void listIteratorForList() {
        //list iterator implements iterator.in this we can do bi-directional iteration .

        ListIterator<String> listIterator=myList.listIterator();

        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private  void getAllElementInListUsingForEach() {
       listIterator.forEachRemaining(System.out::println);

    }

    private void removeElement(Iterator<String> myListIterator) {
        //we can not add or modify element while we iterating through list if we do we will get ConcurrentModificationException.
        //but we can remove element while we iterate
        System.out.println("before remove list size is " + myList.size());
        while (myListIterator.hasNext()) {

            String currentValue = myListIterator.next();
            System.out.println(currentValue);
            if (currentValue.equals("3")) {
                myListIterator.remove();
                System.out.println("After remove list size is " + myList.size());
            }

        }
    }

    private void modificationDuringIteration(Iterator<String> myListIterator) {
        //we can not add or modify element while we iterating through list if we do we will get ConcurrentModificationException.
        //but we can remove element while we iterate


        while (myListIterator.hasNext()) {
            String currentValue = myListIterator.next();
            System.out.println(currentValue);


            if (currentValue.equals("2")) {
                myList.add("4");
            }

        }
    }

    public void initiateMyList() {
        myList.add("1");
        myList.add("2");
        myList.add("3");

        listIterator = myList.iterator();
    }

    public void printAllElementInList(Iterator<String> myListIterator) {

        while (myListIterator.hasNext()) {
            System.out.println(myListIterator.next());
        }
    }

    public void initiateMySet() {
        mySet.add("1");
        mySet.add("2");
        mySet.add("3");

        setIterator = mySet.iterator();
    }

    public void printAllElementInSet(Iterator<String> mySetIterator) {

        while (mySetIterator.hasNext()) {
            System.out.println(mySetIterator.next());
        }
    }
}
