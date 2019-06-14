package com.alog.schedul;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10064028 on 2018/3/8.
 */
public class ScheduledThreadPool {

    public static void main(String[] args) {
        final int index  = 0;
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 2 seconds" + System.currentTimeMillis());
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
