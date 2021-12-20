package com.androidapps.basic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample1 {


        public static void main(String[] args) throws Exception {

            BlockingQueue queue = new ArrayBlockingQueue(3);

            /*queue.add("4");
            queue.add("5");*/

            /*queue.add("4");
            queue.offer("5");*/

            Producer producer = new Producer(queue);
            Consumer consumer = new Consumer(queue);

            new Thread(producer).start();
            new Thread(consumer).start();

            Thread.sleep(4000);
        }

}
