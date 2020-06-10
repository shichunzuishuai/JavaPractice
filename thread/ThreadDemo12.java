package thread;

/**
 * 线程名.join() join 起到的效果是等待线程结束. 当执行到这行代码是,
 * 程序就阻塞了. 一直阻塞到 t1 结束, 才会继续执行.
 */
public class ThreadDemo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程1");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程2");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("主线程执行结束了");
    }
}
