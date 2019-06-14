package barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10064028 on 2018/5/3.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(new Runner(cyclicBarrier, "no1")));
        executorService.submit(new Thread(new Runner(cyclicBarrier, "no2")));
        executorService.submit(new Thread(new Runner(cyclicBarrier, "no3")));

        executorService.shutdown();
    }
}

class Runner implements Runnable{

    private CyclicBarrier cyclicBarrier;

    private String name;


    public Runner(CyclicBarrier cyclicBarrier, String name){
        super();
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * (new Random().nextInt(8)));
            System.out.println(name + " : ready........");
            // barrier的await方法，在所有参与者都已经在此barrier上调用await方法之前，将一直等待
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " : running...........");
    }
}