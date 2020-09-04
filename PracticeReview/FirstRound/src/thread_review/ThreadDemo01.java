package thread_review;

public class ThreadDemo01 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
            while (true){

            }
        }

    }

    public static void main(String[] args) {
        //继承thread类,重写thread中的run方法
        Thread t = new MyThread();
        t.start();
        while (true){

        }
    }
}
