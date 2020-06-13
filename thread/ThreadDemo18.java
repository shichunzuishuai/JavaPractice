package thread;

//volatile的作用可以避免内存可见性,在有多次读入并且有修改的情况下,编译器可能自动优化读取的变量是
//储存在cpu寄存器上的上一次读取的结果
import java.util.Scanner;

public class ThreadDemo18 {
    static class Counter{
        public volatile int flag = 0;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (counter.flag == 0){

                }
                System.out.println("结束");
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入一个整数:");
                counter.flag = scanner.nextInt();
            }
        };
        t2.start();
    }
}
