package text11;

class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            System.out.println("我是线程1");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            System.out.println("我是线程2");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        Thread1 t1=new Thread1();
        t1.start();
        Thread t2=new Thread(new Thread2());
        t2.start();
        for (int i=1;i<=10;i++){
            System.out.println("我是主线程");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
