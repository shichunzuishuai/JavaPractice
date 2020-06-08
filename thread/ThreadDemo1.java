package thread;

public class ThreadDemo1 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("hello world,我是一个线程");
            while (true){

            }
        }
    }
    public static void main(String[] args) {
        //创建线程需要使用Thread类,来创建一个Thread的实例
        //另一方面还需要给这个线程指定,需要执行那些代码
        //此处直接继承Thread类
        //注意:当ThreadUI想被创建出来的时候,内核中并没有随之产生一个线程(PCB)
        Thread t = new MyThread();
        //执行这个start方法,才是真的创建了一个线程
        //此时内核中才会喜欢出现一个PCB这个PCB就会对应让CPU来执行
        //该线程的代码(上面RUN方法中的逻辑)
        t.start();
        while (true){
            //这里啥都不干
        }
    }
}
