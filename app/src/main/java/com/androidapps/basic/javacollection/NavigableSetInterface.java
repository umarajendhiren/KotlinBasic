package com.androidapps.basic.javacollection;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetInterface {
    //NavigableSet interface is subtype of SortedSet  interface .
    //it exactly behaves as sortedSet and it has some additional navigation methods.
    //to use this ,we need to use implementation of this interface which is TreeSet
    NavigableSet<String> navigableSet=new TreeSet<>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        NavigableSetInterface obj=new NavigableSetInterface();
        obj.initiateNavigableSet();

        //obj.sortInDescendingOrder();
        //obj.descendingIterator();

        obj.ceiling();
        obj.floor();
        
        obj.higher();
        obj.lower();
        
        obj.pollFirstAndPollLast();

        //headSet,tailSet,subSet also availble to this interface
    }

    private void pollFirstAndPollLast() {

        NavigableSet<String> original = new TreeSet();
        original.add("1");
        original.add("2");
        original.add("3");

/*The pollFirst() method returns and removes the "first" element in the NavigableSet or null if the set is empty. "First" means smallest element according to the sort order of the set.*/
//first is "1"
        String first = original.pollFirst();
        System.out.println("pollfirst = " + first);

        /*The pollLast() method returns and removes the "last" element in the NavigableSet. "Last" means largest according to the element sorting order of the set*/
        String last=original.pollLast();
        System.out.println("polllast = " + last);
    }

    private void lower() {
        /*The lower() method does the opposite of the higher() method, meaning it returns the highest element that is less than (not equal to) the given parameter.*/
        NavigableSet<String> original = new TreeSet<>();
        original.add("1");
        original.add("2");
        original.add("3");

//lower will be "1"
        String lower = original.lower("2");
        System.out.println("lowerthan2 = " + lower);
    }

    private void higher() {
        /*The higher() method returns the least (smallest) element in this set that is greater than (not equal too) the element passed as parameter to the higher() method.*/
        NavigableSet<String> original = new TreeSet<>();
        original.add("1");
        original.add("2");
        original.add("3");


//higher will be "3".
        String higher = original.higher("2");
        System.out.println("higherthan2 = " + higher);
    }

    private void floor()
    {
        /*The floor() method does the opposite of the ceiling() method, meaning it returns the greatest element that is less than or equal to the given parameter value*/
        NavigableSet<String> original = new TreeSet<>();
        original.add("1");
        original.add("3");
        original.add("5");

        System.out.println("navigableSet.floor = " + original.floor("4"));
    }

    private void ceiling() {
        /*The ceiling() method returns the least (smallest) element in this set that is greater than or equal to the element passed as parameter to the ceiling() method*/
        NavigableSet<String> original = new TreeSet<>();
        original.add("1");
        original.add("3");
        original.add("5");

        System.out.println("navigableSet.ceiling = " + original.ceiling("4"));
    }

    private void descendingIterator() {
        Iterator<String> descendingIterator=navigableSet.descendingIterator();

        while (descendingIterator.hasNext()){
            System.out.println("descendingIterator.next() = " + descendingIterator.next());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void sortInDescendingOrder() {
       NavigableSet<String> descendingOrder= navigableSet.descendingSet();
        descendingOrder.forEach((element)-> System.out.println("descendingelement = " + element));
    }

    private void initiateNavigableSet() {
        navigableSet.add("a");
        navigableSet.add("b");
        navigableSet.add("c");
        navigableSet.add("d");
        navigableSet.add("e");


    }
}
