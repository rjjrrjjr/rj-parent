package thread;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-02-26 20:34
 */
public class TestInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("begin to sleep");
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                System.out.println("中断 sleep");
            }
            System.out.println("end sleep");

        });

        thread.start();
        Thread.sleep(2000L);
        thread.interrupt();
        System.out.println("end");
    }
}

