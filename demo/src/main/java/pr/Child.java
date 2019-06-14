package pr;

/**
 * Created by 10064028 on 2018/3/14.
 */
public class Child extends Parent implements Cloneable{
    private void testa(){
        System.out.println("child");
    }

    public static void testb(){
        System.out.println("child");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Child.testb();
        new Child().testa();

    }
}
