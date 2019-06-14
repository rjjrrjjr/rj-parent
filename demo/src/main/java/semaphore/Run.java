package semaphore;

/**
 * Created by 10064028 on 2018/5/3.
 */
public class Run {

    public static void main(String[] args) {
        Driver driver = new Driver();

        for (int i = 0; i < 5; i ++){
            new Car(driver).start();
        }
    }
}
