package Synchronized;

import java.util.concurrent.TimeUnit;
//一个同步方法可以调用顶一个/
//synachorized获得锁  是可重入的
public class synachoroiezd05 {
    synchronized void m1(){
        System.out.println("m1 start");
         try {
             TimeUnit.SECONDS.sleep(1);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         m2();
        System.out.println("m1 end");
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        new synachoroiezd05().m1();
    }
}
