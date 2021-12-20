package com.androidapps.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {


       // producerAddExample();
       // producerOfferExample();
       // producerOfferWithTimeout();
        producerPoll();
        //producerPollwithTimeOut();
       // peekAndelementAndContains();
       // putSizeAndCapacityOfBQ();

       // removeElementFromBq();




       /* queue.add("2");
        queue.add("1");*/
       /* queue.add(1);

        System.out.println(queue.peek());

        queue.add(2);*/


/*
        queue.offer("4");
        System.out.println(queue.peek());

       if(!queue.offer("5")) {

           System.out.println("Can not add element .Queue is full");
       }*/
        //queue.offer("4");
     /*   queue.offer("4");


        try {
            queue.offer("5",3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

     /*   try {
            queue.offer("5",3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
     /*   try {
            queue.put("1");



        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        /*try {

            //Thread.sleep(3000);
            queue.put("4");
            queue.put("3");



        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    }

    private void removeElementFromBq() {

        //capacity 3



        try {
            queue.put("1");
            queue.put("2");
            queue.put("3");
            System.out.println(queue.remove("1"));
            System.out.println(queue.remove("4"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void peekAndelementAndContains() {

        try {
            //capacity 3
            System.out.println(queue.peek());

            queue.put("1");
            queue.put("2");
            queue.put("3");

            System.out.println(queue.peek());
            System.out.println(queue.contains("2"));
            System.out.println(queue.contains("4"));
            System.out.println(queue.element());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void producerPoll() {
        queue.add("1");
       System.out.println(queue.poll());
       System.out.println(queue.poll());
    }
    private void producerPollwithTimeOut() {



        try {
            queue.add("1");

            Thread.sleep(1000);
            /*System.out.println(queue.poll());
            System.out.println(queue.poll());*/

            queue.put("2");




            System.out.println(queue.poll(1000, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(4000, TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void producerOfferWithTimeout() {
        //capacity 1
         queue.offer("1");
             try {
            queue.offer("5",3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void producerOfferExample() {
        //capacity 1
        queue.offer("1");
        System.out.println(queue.peek());
        queue.offer("2");
    }

    private void producerAddExample() {
        //capacity 1
        queue.add("1");
        System.out.println(queue.peek());
        queue.add("2");
    }

    private void putSizeAndCapacityOfBQ() {

        queue.add("1");
        queue.add("2");
    }


}
