package test2;

import static java.lang.Thread.sleep;

public class Dianyuan {
    private int shuliang=0;
    public synchronized void shengchang(){
       while(true) {
           if (shuliang < 1) {
               shuliang++;
               System.out.println(Thread.currentThread()+"生产第" + shuliang);
               try {
                   sleep(10);
               }catch (Exception e){
                   e.printStackTrace();

               }
               notify();
           } else {
               try {
                   wait();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }
    }
    public synchronized void xiaofei() {
        while (true) {
            if (shuliang > 0) {
                System.out.println(Thread.currentThread()+"消费第" + shuliang);
                shuliang--;
                try {
                    sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
                notify();
            }
            else{
                try{
                wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
class Xiaofei extends Thread{
    private Dianyuan d;
    public Xiaofei(String name,Dianyuan d){
        super(name);
        this.d=d;
    }
    @Override
    public void run(){
        d.xiaofei();
    }
}
class Shengchang extends Thread{
    private Dianyuan d;
    public Shengchang(String name,Dianyuan d){
        super(name);
        this.d=d;
    }
    @Override
    public void run(){
        d.shengchang();
    }
}
class Test{
    public static void main(String[] args) {
        Dianyuan d=new Dianyuan();
        Shengchang shengchang=new Shengchang("第一号",d);
        Xiaofei xiaofei=new Xiaofei("第一号",d);
        shengchang.start();
        xiaofei.start();
    }
}