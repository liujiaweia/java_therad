package Synchronized;

public class synchoronized01 {
    private static int count = 10;
//    public void m(){
//        synchronized (this){
//            count--;
//            System.out.println(Thread.currentThread().getName()+"count = "+count);
//        }
//
    public synchronized static void m(){
        count--;
        System.out.println(Thread.currentThread().getName()+"count = "+count);
    }
    public static void mm(){
        synchronized(synchoronized01.class){
            count--;
        }
    }
}
