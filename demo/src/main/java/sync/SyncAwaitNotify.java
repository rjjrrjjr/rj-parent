package sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-03-04 15:36
 */
public class SyncAwaitNotify {

    public static void main(String[] args) throws InterruptedException {

        Object oA = new Object();
        Object oB = new Object();
        Object oC = new Object();

        AtomicInteger atomicInteger = new AtomicInteger(29);

        new Thread(() -> {
            while (atomicInteger.getAndDecrement() >= 0) {
                try {
                    synchronized (oC){
                        System.out.println("获取到锁==oC");
                        synchronized (oA){
                            Thread.sleep(50);
                            System.out.print("A");
                            oA.notifyAll();
                        }
                        oC.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "tA").start();


        new Thread(() -> {
            while (atomicInteger.getAndDecrement() >= 0){
                try {
                    synchronized (oA){
                        System.out.println("获取到锁==oA");
                        synchronized (oB){
                            Thread.sleep(50);
                            System.out.print("B");
                            oB.notifyAll();
                        }
                        oA.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "tB").start();


        new Thread(() -> {
            while (atomicInteger.getAndDecrement() >= 0){
                try {
                    synchronized (oB){
                        Thread.sleep(50);
                        System.out.println("获取到锁==oB");
                        synchronized (oC){
                            System.out.print("C, ");
                            oC.notifyAll();
                        }
                        oB.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "tC").start();
    }
}
