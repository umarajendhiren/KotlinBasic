package com.androidapps.basic.javacollection;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class iterable {

    //the class extends iterable interface can be iterated.
    //list,set are implements collection interface and collection interface implements iterable interface so all child of collection can be iterable.
    //we can do iteration using 4 method
    //for-each loop
    //using iterator
    //using forEach() method
    //using forr loop

    List<String> stringList=new ArrayList<>();



        @RequiresApi(api = Build.VERSION_CODES.N)
        public static void main(String[] args){
        iterable iterableInstance=new iterable();
        iterableInstance.initiateList();

        //iterableInstance.iterateUsingForEachLoop();
       // iterableInstance.iterateUsingIterator();
       // iterableInstance.iterateUsingForEachMethod();
       //iterableInstance.iterateUsingForLoop();
            iterableInstance.iterateUingStreamApi();
       //iterableInstance.getSpliterator();


        }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void iterateUingStreamApi() {
        Stream<String> stringStream=stringList.stream();

        stringStream.forEach((element)-> System.out.println("element = " + element));

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getSpliterator() {
        Spliterator<String> stringSpliterator=stringList.spliterator();
        System.out.println("stringSpliterator = " +  stringSpliterator.characteristics());
        System.out.println("stringSpliterator = " +  stringSpliterator.estimateSize());
        System.out.println("stringSpliterator = " +  stringSpliterator.hasCharacteristics(1));

    }

    private void iterateUsingForLoop() {
            for(int i=0;i<stringList.size();i++){
                System.out.println("stringList = " + stringList.get(i));
            }
    }

    private void initiateList() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void iterateUsingForEachMethod() {
        // Iterate an Iterable via its forEach() Method
        stringList.forEach((element)-> System.out.println("element = " + element));
    }

    private void iterateUsingIterator() {
        //Iterate an Iterable via an Iterator

        Iterator<String> listIterator=stringList.iterator();
        while (listIterator.hasNext()){
            System.out.println("listIterator =" +listIterator.next());
        }
    }

    private void iterateUsingForEachLoop() {
        //Iterate an Iterable With the for-each Loop
        //this loop is perform slower than for loop because it  will internally creates iterator instance and calls hasNext() and next()

        for(String listItem:stringList){
            System.out.println(listItem);
        }
    }

}
