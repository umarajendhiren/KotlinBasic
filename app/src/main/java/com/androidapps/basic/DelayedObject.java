package com.androidapps.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedObject implements Delayed {

    // Java Program Demonstrate DelayQueue methods
    // The DelayObject for DelayQueue
// It must implement Delayed and
// its getDelay() and compareTo() method


    private String name;
    private long time;

    // Constructor of DelayObject
    public DelayedObject(String name, long delayTime) {
        this.name = name;
        this.time = System.currentTimeMillis()
                + delayTime;
    }

    // Implementing getDelay() method of Delayed
    @Override
    public long getDelay(TimeUnit unit) {
        long diff = time - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    // Implementing compareTo() method of Delayed
    @Override
    public int compareTo(Delayed obj) {
        if (this.time < ((DelayedObject) obj).time) {
            return -1;
        }
        if (this.time > ((DelayedObject) obj).time) {
            return 1;
        }
        return 0;
    }

    // Implementing toString()
    // method of Delayed
    @Override
    public String toString() {
        return "\n{"
                + "name=" + name
                + ", time=" + time
                + "}";
    }
}

// Driver Class
class GFG {
    public static void main(String[] args)
            throws InterruptedException {

        // create object of DelayQueue
        // using DelayQueue() constructor
        BlockingQueue<DelayedObject> DQ
                = new DelayQueue<DelayedObject>();

        // Add numbers to end of DelayQueue
        // using add() method
        DQ.add(new DelayedObject("A", 1));
        DQ.add(new DelayedObject("B", 2));
        DQ.add(new DelayedObject("C", 3));
        DQ.add(new DelayedObject("D", 4));

        // print queue
        System.out.println("DelayQueue: "
                + DQ);

        // print the head using peek() method
        System.out.println("Head of DelayQueue: "
                + DQ.peek());

        // print the size using size() method
        System.out.println("Size of DelayQueue: "
                + DQ.size());

        // remove the head using poll() method
        System.out.println("Head of DelayQueue: "
                + DQ.poll());

        // print the size using size() method
        System.out.println("Size of DelayQueue: "
                + DQ.size());

        // clear the DelayQueue using clear() method
        DQ.clear();
        System.out.println("Size of DelayQueue"
                + " after clear: "
                + DQ.size());
    }
}

