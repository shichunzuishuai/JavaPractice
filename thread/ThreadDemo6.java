package thread;

public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("宋江"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                    //
                    //System.out.println(this.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // run 方法的执行过程就代表着系统内线程的生命周期.
                // run 方法执行中, 内核的线程就存在.
                // run 方法执行完毕, 内核中的线程就随之销毁.
                System.out.println("线程要退出了");
            }
        };
        //这一组属性,只要县城以创建,属性就不变了
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        //是否后台线程,关于后台线程，需要记住一点：JVM会在一个进程的所有非后台线程结束后，才会结束运行。
        System.out.println(t.isDaemon());
        System.out.println(t.getId());
        //这几个属性会随着线程的运行而发生变化
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());
        t.start();
        while (t.isAlive()){
            System.out.println("宋江线程正在运行");
            System.out.println(t.getState());
            System.out.println(t.isInterrupted());
            Thread.sleep(300);
        }
    }
}
