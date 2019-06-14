package exception;

/**
 * Created by 10064028 on 2018/5/8.
 */
public class TestException {

    public static void main(String[] args) {
        try {
            throw new RuntimeException("abc");
        }catch (RuntimeException e){
            System.out.println("catch runtimeexception");
        }catch (Exception e){
            System.out.println("catch exception");
        }
    }
}
