package com.alog.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10064028 on 2018/3/8.
 */
public class CacheThreadPool {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++){
            final int index = i;
            try {
                Thread.sleep(index * 10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }
}
