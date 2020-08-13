package Volatitle;

import java.util.ArrayList;
import java.util.List;

public class volatitle02 {
    volatile int count = 0;
    //int count = 0;
    void m(){
        for(int i=0;i<10000;i++) count++;
    }

    public static void main(String[] args) {
        volatitle02 t = new volatitle02();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            threads.forEach((o)->{
                try {
                    o.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(t.count);
        }
    }
}
