package com.androidapps.basic.javacollection;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;

public class collection {
  public  static List<String> list1=new ArrayList<>();
  public  static List<String> list2=new ArrayList<>();

    public static void main(String[] args) {
        collection collection=new collection();
       collection.initiateList();


       /* System.out.println("removeAll " + list1.removeAll(list2));

        System.out.println("addAll " + list1.addAll(list2));
        System.out.println("retainAll " + list1.retainAll(list2));*/

        //collection.addAll();
        //collection.removeAll();
       // collection.retainAll();
        //collection.containsAll();
        //collection.replaceAll();

    }

    private void replaceAll() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //System.out.println(list1.replaceAll((UnaryOperator<String>) list2));
        }

    }

    private void containsAll() {
        System.out.println("addAll " + list1.addAll(list2));
        System.out.println("removeAt0 " +  list1.remove(1));
        System.out.println("sizeAfterremoved " +  list1.size());

        System.out.println("contains " +  list1.contains("1"));
        System.out.println("containsAll " + list1.containsAll(list2));

        


        if(list1.containsAll(list2)){
        for (String afterRemoved:list1){
            System.out.println("list1 = " + afterRemoved);
        }}
    }

    private void retainAll() {

        System.out.println("addAll " + list1.addAll(list2));

        System.out.println("retainAll " + list1.retainAll(list2));
        for (String afterRemoved:list1){
            System.out.println("list1 = " + afterRemoved);
        }
    }

    private void removeAll() {
        System.out.println("addAll " + list1.addAll(list2));
        System.out.println("removeAt " + list1.remove(3));
        System.out.println("remove " + list1.remove("1"));
        System.out.println("removeAll " + list1.removeAll(list2));
        for (String afterRemoved:list1){
            System.out.println("list1 = " + afterRemoved);
        }
    }

    private void addAll() {

        System.out.println("add " + list1.add("4"));
        System.out.println("addAll " + list1.addAll(list2));
        list1.add(5,"5");

        for (String mergedList:list1){
            System.out.println("list1 = " + mergedList);
        }
    }



    private void initiateList() {
        list1.add("1");
        list1.add("2");
        list1.add("3");

        list2.add("A");
        list2.add("B");
        list2.add("C");

    }
}
