package com.androidapps.basic.javacollection;

import java.util.Deque;
import java.util.LinkedList;

public class DeQueueInterface {
    Deque<String> stringDeque = new LinkedList<>();

    public static void main(String[] args) {
        DeQueueInterface obj = new DeQueueInterface();
        obj.AllMethods();

    }

    private void AllMethods() {

        //to add element
       /* add()
        addLast()
        addFirst()
        offer()
        offerFirst()
        offerLast()
        push()*/


        //to peek at element at deque
        /*peek()
        peekFirst()
        peekLast()
        getFirst()
        getLast()*/

        //remove element from deque
      /*  remove()
        removeFirst()
        removeLast()
        poll()
        pollFirst()
        pollLast()
        pop()*/


        //contains() ,size()
        //iterate using iterator or using for each loop



        stringDeque.add("first element");
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.addFirst("second element");
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.addLast("theird element");
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.offer("4th element");
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.offerFirst("5th element");
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.offerLast("6th element");
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.push("7th element");

        System.out.println("stringDeque = " + stringDeque);


        //get element
        System.out.println("peek = " + stringDeque.peek());
        System.out.println("peekFirst = " + stringDeque.peekFirst());
        System.out.println("peekLast = " + stringDeque.peekLast());
        System.out.println("getFirst = " + stringDeque.getFirst());
        System.out.println("getLast = " + stringDeque.getLast());


        //remove element
        stringDeque.remove();
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.removeFirst();
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.removeLast();
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.poll();
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.pollFirst();
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.pollLast();
        System.out.println("stringDeque = " + stringDeque);
        stringDeque.pop();
        System.out.println("stringDeque = " + stringDeque);

    }
}
