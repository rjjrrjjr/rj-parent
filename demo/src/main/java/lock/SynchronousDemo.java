package lock;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by 10064028 on 2018/3/9.
 */
public class SynchronousDemo {
    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("========================put begin");
                    synchronousQueue.put(1);
                    System.out.println("================pupppppp");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("======================put over");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("========================take begin");
                    System.out.println(synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("=================================take over");
            }
        }).start();
    }
}
