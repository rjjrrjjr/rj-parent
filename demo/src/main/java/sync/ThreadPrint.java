package sync;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-03-04 16:32
 */
public class ThreadPrint implements Runnable {

    private String name;
    private Object prev;
    private Object self;
    private Thread thread;

    public ThreadPrint(String name,Object prev,Object self) {
        this.name=name;
        this.prev=prev;
        this.self=self;
        thread=new Thread(this,name);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        int count=10;
        while (count>0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object aObject=new Object();
        Object bObject=new Object();
        Object cObject=new Object();

        ThreadPrint pa=new ThreadPrint("A", cObject, aObject);
        ThreadPrint pb=new ThreadPrint("B", aObject, bObject);
        ThreadPrint pc=new ThreadPrint("c, ", bObject, cObject);

        pa.thread.start();
//         try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        //Thread.sleep(100L);
        pb.thread.start();
//         try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        //Thread.sleep(100L);
        pc.thread.start();
//         try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
    }

}
