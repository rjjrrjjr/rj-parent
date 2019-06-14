package semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by 10064028 on 2018/5/3.
 */
public class Driver {

    // Semaphore又称信号量，是操作系统中的一个概念，在Java并发编程中，信号量控制的是线程并发的数量
    private Semaphore semaphore = new Semaphore(3);

    public void driverCar(){
        try {
            // 从信号量中获取一个允许机会
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " start at " + System.currentTimeMillis());
            Thread.sleep(2000L);
            System.out.println(Thread.currentThread().getName() + " stop at " + System.currentTimeMillis());
            // 释放允许，将占有的信号量归还
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
