package Synchronized;

public class synchoronized02 implements Runnable{

    private int count = 100;
    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"count"+count);
    }

    public static void main(String[] args) {
        synchoronized02 synchoronized02 = new synchoronized02();
        for(int i=0;i<100;i++){
            new Thread(synchoronized02,"TTREAD"+i).start();
        }
    }
}
