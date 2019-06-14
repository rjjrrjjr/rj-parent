package com.alog.sync;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by 10064028 on 2018/3/8.
 */
public class SynchronizedQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put---------------start");
                try {
                    synchronousQueue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("put---------------over");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take-------------------start");
                try {
                    System.out.println(synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("take-------------------over");
            }
        });

        putThread.start();
        Thread.sleep(1000);
        takeThread.start();
    }
}
