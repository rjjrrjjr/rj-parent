package invokeStatic;

/**
 * Created by 10064028 on 2018/4/17.
 */
public class TestInvokeStatic {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(6);
            System.out.println("main========" + thread.interrupted());
            System.out.println("是否停止1？="+thread.isInterrupted());
            thread.interrupt();
            System.out.println("============================");
            System.out.println("main========" + thread.interrupted());
            System.out.println("是否停止1？="+thread.isInterrupted());
            System.out.println("是否停止1？="+thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            //Thread.currentThread().interrupt();
            System.out.println("是否停止1？=" + thread.interrupted());//false
            System.out.println("是否停止2？=" + thread.interrupted());//false main线程没有被中断!!!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 */

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 1000; i ++){
            if (this.isInterrupted()){
                System.out.println("exit");
                break;
            }
            System.out.println("i = " + (i + 1));
        }
        System.out.println("gg");
    }
}

/**
class MyThread extends Thread {
@Override
public void run() {
super.run();
for (int i = 0; i < 500000; i++) {
if (this.interrupted()) {
System.out.println("should be stopped and exit");
break;
}
System.out.println("i=" + (i + 1));
}
System.out.println("this line is also executed. thread does not stopped");//尽管线程被中断,但并没有结束运行。这行代码还是会被执行
}
}
 */
