package thread;
//使用wait 和 notify,都必须搭配锁使用
//wait操作做了三件事  1.释放锁  2. 等待通知  3. 尝试重新获取锁
import java.util.Scanner;

public class ThreadDemo21 {
    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (object) {
                    while (true){
                        try {
                            System.out.println("wait开始");
                            object.wait();
                            System.out.println("wait结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("输入一个数,继续执行notify");
                    int n = scanner.nextInt();
                    synchronized (object) {
                        System.out.println("notify开始");
                        object.notify();
                        System.out.println("notify结束");
                    }
                }
            }
        };
        t2.start();
    }
}
