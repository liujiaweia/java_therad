package Volatitle;

import java.util.concurrent.TimeUnit;

//使得一个变量在多个线程间可见
public class Volatitle01 {
    volatile boolean running = true;

    //    boolean running = true;
    void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        Volatitle01 t = new Volatitle01();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
