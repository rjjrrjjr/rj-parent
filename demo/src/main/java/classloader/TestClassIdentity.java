package classloader;

/**
 * Created by 10064028 on 2018/3/5.
 */
public class TestClassIdentity {

    //thread未设置则继承其父线程的上下文类加载器
    public static void main(String[] args) {
        System.out.println(new Thread().getContextClassLoader().toString());
    }
}
