package Synchronized;

import java.util.concurrent.TimeUnit;
//对写加锁   对读不加锁
public class synachoroized04 {
    String name;
    double balance;
    public synchronized void set(String name,double balance){
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }
    public double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        synachoroized04 a = new synachoroized04();
        new Thread(()->a.set("zhangsan",100.0)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));
    }
}
