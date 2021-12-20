package com.androidapps.basic.javacollection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class stackInterface {
    public static void main(String[] args) {
        stackInterface obj=new stackInterface();
        obj.allMethods();
        obj.ReverseListUsingStack();
        obj.UseAJavaDequeasStack();
    }

    private void UseAJavaDequeasStack() {
        Deque<String> dequeAsStack = new ArrayDeque<>();

        dequeAsStack.push("one");
        dequeAsStack.push("two");
        dequeAsStack.push("three");

        String one   = dequeAsStack.pop();
        String two   = dequeAsStack.pop();
        String three = dequeAsStack.pop();
        System.out.println("one = " + one);
        System.out.println("two = " + two);
        System.out.println("three = " + three);
    }

    private void ReverseListUsingStack() {

        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);

        Stack<String> stack = new Stack<String>();
        while(list.size() > 0) {
            stack.push(list.remove(0));
        }

        while(stack.size() > 0){
            list.add(stack.pop());
        }

        System.out.println(list);
    }

    private void allMethods() {
        Stack<String> stringStack=new Stack<>();

        stringStack.push("1");
        stringStack.push("2");
        stringStack.push("3");
        System.out.println("stringStack = " + stringStack);

        System.out.println("stringStackpeak = " + stringStack.peek());
        System.out.println("stringStackpop = " + stringStack.pop());
        System.out.println("search = " + stringStack.search("3"));
        System.out.println("search = " + stringStack.size());


        //we can use iterator ,for-each,stream to iterate element
        Iterator<String> stringIterator=stringStack.iterator();
        while (stringIterator.hasNext()){
            System.out.println("stringIterator.next() = " + stringIterator.next());

        }
    }
}
