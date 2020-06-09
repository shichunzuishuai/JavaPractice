package thread;

public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t = new Thread("这是一个线程的名字,可以很长"){
            @Override
            public void run() {
                System.out.println("我是一个新线程");
            }
        };
        t.start();
    }
}
