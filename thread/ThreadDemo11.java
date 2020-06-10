package thread;

/**
 * 抢占式执行的特点:没法控制那个线程先走,但是可以控制哪个线程先结束那个后结束.
 */
public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("我是一个新线程");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        while (true){
            System.out.println("我是一个主线程");
            Thread.sleep(500);
        }
    }
}
