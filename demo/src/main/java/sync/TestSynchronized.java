package sync;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 10064028 on 2018/4/10.
 */
public class TestSynchronized {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
    }
}
