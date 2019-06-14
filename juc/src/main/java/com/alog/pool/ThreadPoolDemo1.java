package com.alog.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10064028 on 2018/3/7.
 */
public class ThreadPoolDemo1 {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();
        MyThread myThread5 = new MyThread();
        pool.execute(myThread1);
        pool.execute(myThread2);
        pool.execute(myThread3);
        pool.execute(myThread4);
        pool.execute(myThread5);
        pool.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}