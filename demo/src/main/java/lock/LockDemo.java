package lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 10064028 on 2018/3/9.
 */
public class LockDemo {

    public static void main(String[] args) {
        DefQueue defQueue = new DefQueue();
        for (int i = 0; i < 3; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        defQueue.put(new Random().nextInt(10000));
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        defQueue.get();
                    }
                }
            }).start();
        }
    }
}

class DefQueue{
    private int data;
    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void get(){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to get data");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " get data ==================" + data);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }

    public void put(int data){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to write data");
            Thread.sleep(1000);
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " has wrote the data ==========================" + data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }
}
