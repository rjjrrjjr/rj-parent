package invokeStatic;

/**
 * Created by 10064028 on 2018/4/17.
 */
public class testSt {
    public static void main(String[] args) {
        new testSt().getStatic();
    }

    private static void getStatic(){
        System.out.println("=================================static invoke");
    }
}
