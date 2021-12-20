package com.androidapps.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer implements  Runnable{
    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {

      //  ConsumerOfferWithTimeout();
     //   getSizeAndCapacityOfBq();
        consumerPollwithTimeOut();



        /*System.out.println(queue.contains("4"));
        System.out.println(queue.contains("3"));*/

/*
        System.out.println(queue.peek());
        System.out.println(queue.element());*/

      /*  System.out.println(queue.remove("2"));

        System.out.println(queue.peek());

        System.out.println(queue.remove("1"));*/

       // System.out.println(queue.poll());
       /* try {
            System.out.println(queue.poll(1000, TimeUnit.MILLISECONDS));
            System.out.println(queue.poll(4000, TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

       /* try {


            System.out.println(queue.take());
            System.out.println(queue.take());

            Thread.sleep(3000);
            System.out.println(queue.peek());
            System.out.println(queue.remainingCapacity());

                  } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private void consumerPollwithTimeOut() {
        queue.remove("1");
    }

    private void ConsumerOfferWithTimeout() {

        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getSizeAndCapacityOfBq() {
        List<String> newqueue=new ArrayList<>();


        System.out.println(queue.drainTo(newqueue));
        System.out.println(newqueue.size());
        System.out.println(newqueue.get(0));

        System.out.println(queue.size());
        System.out.println(queue.remainingCapacity());

        /*queue.drainTo(newqueue);
        Log.d( "newQusizeAfterDrain", String.valueOf(newqueue.size()));
        Log.d( "newQuelementAt0", String.valueOf(newqueue.get(0)));

        Log.d( "BqSizeAfterDrain", String.valueOf(queue.size()));
        Log.d( "capasityOfBq", String.valueOf(queue.remainingCapacity()));*/
    }
}
