package Synchronized;

public class synachoroized021 implements Runnable{
    private int count = 10;
    public synchronized void run(){
        count--;
        System.out.println(Thread.currentThread().getName()+"count="+count);
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            synachoroized021 synachoroized021 = new synachoroized021();
            new Thread(synachoroized021,"THREAD"+i).start();
        }
    }
}
