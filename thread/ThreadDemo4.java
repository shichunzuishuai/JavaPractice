package thread;

public class ThreadDemo4 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        //t.run就是一个普通的调用方法,并没有在进程中创建对应的线程,只有start才会创建pcb.
        t.run();
        //t.start();
    }
}
