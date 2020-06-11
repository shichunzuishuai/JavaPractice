package thread;

public class ThreadDemo15 {
    static class Counter{
        int count = 0;
        synchronized public  void increase(){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };
        t1.start();
        //t1.join();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);
    }
}
