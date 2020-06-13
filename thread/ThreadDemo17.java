package thread;

import java.util.Scanner;

//测试如果一个线程尝试去获取已经上锁的锁,就会进入阻塞状态
//若果两个线程尝试获取两个不同的锁,没有影响
public class ThreadDemo17 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                synchronized (locker){
                    System.out.println("请输入一个整数");
                    int num = scanner.nextInt();//如果用户一直不输入,就会进入阻塞状态
                    System.out.println("num = " + num);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (locker){
                        System.out.println("线程2获取到锁了");
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t2.start();
    }
}
