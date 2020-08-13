package xiancheng;

import java.util.concurrent.*;

public class HowtoCreateThread {
    static class Mythread extends Thread{
        public void run(){
            System.out.println("hello myThread");
        }
    }
    static class MyRun implements Runnable{

        @Override
        public void run() {
            System.out.println("hello myrun");
        }
    }
    static class Mycall implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("hello mycall");
            return "sucess";
        }
    }

    public static void main(String[] args) {
        new Mythread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("hello lambda");
        }).start();
        Thread t = new Thread(new FutureTask<String>(new Mycall()));
        t.start();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("hello Threadpool");
        });
        service.shutdown();
    }
}
