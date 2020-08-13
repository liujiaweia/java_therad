package Synchronized;

//对某个对象加锁
public class Synchronied {
    private int count = 10;
    private Object o = new Object();
    public void m() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }

    public static void main(String[] args) {
        Synchronied synchronied = new Synchronied();
        synchronied.m();
    }
}
