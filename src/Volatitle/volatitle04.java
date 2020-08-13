package Volatitle;

import java.util.concurrent.TimeUnit;

public class volatitle04 {
    Object o = new Object();
    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        volatitle04 t = new volatitle04();
        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(t::m,"t2");

        //锁对象发生改变。所以t2线程得到执行、
        t.o = new Object();
        t2.start();
    }
}
