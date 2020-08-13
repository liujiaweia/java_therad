package Synchronized;

import java.util.concurrent.TimeUnit;

//重入锁
public class synachoroized06 {
    synchronized void m(){
        System.out.println("m1 start");
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }

    public static void main(String[] args) {
        new T().m();
    }


}
class T extends synachoroized06{
    synchronized void m(){
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
