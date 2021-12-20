package com.androidapps.basic.javacollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueInterface {
    public static void main(String[] args) {
        QueueInterface obj = new QueueInterface();
        obj.methods();
    }

    private void methods() {
        Queue<String> queue = new LinkedList<>();

        //if there is space add element else throw exception
        queue.add("A");
        queue.add("B");
        queue.add("C");

        //if there is space add element and return true else return false
        System.out.println("offer = " + queue.offer("D"));

        //remove head of queue.if queue is empty return null
        System.out.println("poll = " + queue.poll());


        ////remove head of queue.if queue is empty throw exception
        System.out.println("remove = " + queue.remove());
        queue.remove();

        //remove all the element
       // queue.clear();

        //retrive the head of queue and does not remove.if queue is empty returns null.
        System.out.println("peek = " + queue.peek());


        //retrive the head of queue and does not remove.if queue is empty throws exception.
        System.out.println("element = " + queue.element());


        //get que size
        queue.size();

        //check if queue contains element
        queue.contains("A");

        //iterate element in queue
        Iterator<String> queueIterator = queue.iterator();
        while (queueIterator.hasNext()) {
            System.out.println("queueIterator.next() = " + queueIterator.next());
        }

        //access via new for-loop
        for (String element : queue) {
            //do something with each element
            System.out.println("element = " + element);
        }


    }
}
