package com.androidapps.basic.javacollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListInterface {

    List<String> list = new ArrayList<>();
    List<String> destinationList = new ArrayList<>();


    public static void main(String[] args) {
        ListInterface obj = new ListInterface();
        obj.initiatelIst();

        //obj.addAndAddAllToList();
        //obj.insertNullValueToList();
        //obj.insertElementAtSpecificIndex();
        // obj.getElementAtParticularIndex();
        //obj.getIndexOfParticularElement();
        // obj.listContainsParticularElement();
       // obj.removeElementFromList();
       // obj.retainAll();
        //obj.subList();
        
        //obj.convertingListToSet();
        //obj.convertingListToArray();
       // obj.convertArrayToList();



    }

    private void convertArrayToList() {
        String[] strings=new String[]{"1","2","3"};
        List<String> list= Arrays.asList(strings);
        for (String listelement : list) {
            System.out.println("arrayToList " + listelement);
        }
    }

    private void convertingListToArray() {
      String[] stringsArray= list.toArray(new String[0]);
        System.out.println("stringsArray " + stringsArray.length);
        System.out.println("stringsArrayAt0 " + stringsArray[0]);
        System.out.println("stringsArrayAt1 " + stringsArray[1]);
        System.out.println("stringsArrayAt2 " + stringsArray[2]);
        System.out.println("stringsArrayAt2 " + stringsArray[3]);
    }

    private void convertingListToSet() {

        //set remove duplicate values
        List<String> list      = new ArrayList<>();

        list.add("element 1");
        list.add("element 2");
        list.add("element 2");
        list.add("element 3");
        list.add("element 3");
        list.add("element 4");

        Set<String> set = new HashSet<>();
        set.addAll(list);
        for (String setElement : set) {
            System.out.println("setElement " + setElement);
        }
    }

    private void subList() {
        List<String> list      = new ArrayList<>();

        list.add("element 1");
        list.add("element 2");
        list.add("element 3");
        list.add("element 4");
        list.add("element 5");

        //will include element at 1 and exclude element at 3

        List<String> sublist = list.subList(1, 3);
        for (String listElement : sublist) {
            System.out.println("sublist " + listElement);
        }
    }

    private void retainAll() {
        List<String> sourcelist      = new ArrayList<>();
        List<String> otherList = new ArrayList<>();

        String element1 = "element 1";
        String element2 = "element 2";
        String element3 = "element 3";
        String element4 = "element 4";

        sourcelist.add(element1);
        sourcelist.add(element2);
        sourcelist.add(element3);

        otherList.add(element1);
        otherList.add(element3);
        otherList.add(element4);

        sourcelist.retainAll(otherList);
        for (String listElement : sourcelist) {
            System.out.println("retainedList " + listElement);
        }
    }

    private void removeElementFromList() {

        //list contains 1,2,3
        list.remove("one");
        //once we removed "one" at 0 list ,all subsequent elements are  moved up.now "two" at 0 index.
        list.remove(0);

        for (String listElement : list) {
            System.out.println("afterremoved " + listElement);
        }
        //if we try to remove element at one ,if there is no element at i will throw Index 1 out of bounds for length.
        // list.remove(1);
        System.out.println("before cleared " + list.size());
        list.clear();
        System.out.println("afterCleared " + list.size());
        //can call clear after clear.
        list.clear();

    }

    private void listContainsParticularElement() {
        System.out.println("isListContainsOne " + list.contains("one"));

    }

    private void getIndexOfParticularElement() {

        list.add("one");
        //now the list contain 1,2,3,1
        //indexof() method return index of  first occurrence of element in the list.
        //lastIndexof() method return index of  last occurrence of element in the list.
        int indexOfOne = list.indexOf("one");
        System.out.println("indexOfOne " + indexOfOne);

        int lastIndexOfOne = list.lastIndexOf("one");
        System.out.println("lastIndexOfOne " + lastIndexOfOne);
    }

    private void getElementAtParticularIndex() {

        System.out.println("elementAtIndex0 " + list.get(0));
    }

    private void insertElementAtSpecificIndex() {
        //if there is nothing at given index ,it just add element at given index.
        //if there is element at given index,list will push down the existing element and insert the new element  at given index .
        list.add(0, "1");
        for (String listElement : list) {
            System.out.println("addedAtIndex " + listElement);
        }
    }

    private void insertNullValueToList() {
        //we can insert null value to list
        list.add(null);
        for (String listElement : list) {
            System.out.println("added null " + listElement);
        }
    }

    private void addAndAddAllToList() {
        list.add("four");
        list.add("five");
        list.addAll(list);
        for (String listElement : list) {
            System.out.println("added element " + listElement);
        }
    }

    private void initiatelIst() {
        list.add("one");
        list.add("two");
        list.add("three");

    }
}
