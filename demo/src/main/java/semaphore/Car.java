package semaphore;

/**
 * Created by 10064028 on 2018/5/3.
 */
public class Car extends Thread {

    private Driver driver;

    public Car(Driver driver){
        super();
        this.driver = driver;
    }

    @Override
    public void run() {
        driver.driverCar();
    }
}
