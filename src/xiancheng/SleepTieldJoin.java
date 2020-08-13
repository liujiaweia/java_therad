package xiancheng;

import java.util.concurrent.TimeUnit;

public class SleepTieldJoin {
    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testjoin();

    }
    //简单的睡眠
    static void testSleep(){
        new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println("A"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //做让步 抢不抢得到不知道
    static void testYield(){
        new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("A"+i);
                if(i%10==0) Thread.yield();
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println(".........B"+i);
                if(i%10==0) Thread.yield();
            }
        }).start();
    }
    static void testjoin(){
        Thread T1 = new Thread(()->{
           for(int i=0;i<100;i++){
               System.out.println("A"+i);
               try {
//                   Thread.sleep(500);
                   TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        Thread T2 =new Thread(()->{
           try {
               T1.join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           for(int i=0;i<100;i++){
               System.out.println("A"+i);
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        T1.start();
        T2.start();
    }

}
