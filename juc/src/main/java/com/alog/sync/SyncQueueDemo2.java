package com.alog.sync;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10064028 on 2018/3/8.
 */
public class SyncQueueDemo2 {
    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        Supplier p1 = new Supplier("p1", synchronousQueue, 10);
        Supplier p2 = new Supplier("p2", synchronousQueue, 50);

        Consumer c1 = new Consumer("c1", synchronousQueue);
        Consumer c2 = new Consumer("c2", synchronousQueue);

        p1.start();
        TimeUnit.MILLISECONDS.sleep(100);
        c1.start();
        TimeUnit.MILLISECONDS.sleep(100);
        c2.start();
        TimeUnit.MILLISECONDS.sleep(100);
        p2.start();
        TimeUnit.MILLISECONDS.sleep(100);
    }
    static class Consumer extends Thread{
        private SynchronousQueue<Integer> queue;
        public Consumer(String name, SynchronousQueue<Integer> queue){
            super(name);
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println(getName() + " take result " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Supplier extends Thread{
        private SynchronousQueue<Integer> queue;
        private int n;
        public Supplier(String name, SynchronousQueue<Integer> queue, int n){
            super(name);
            this.queue = queue;
            this.n = n;
        }
        @Override
        public void run() {
            super.run();
            System.out.println(getName() + " offset result " + queue.offer(n));
        }
    }
}
