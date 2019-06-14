package sync;

/**
 * Created by 10064028 on 2018/4/25.
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child thread end");
            }
        });

        thread.start();
        thread.join();

        System.out.println("===========main end");
    }
}
