package thread;

public class ThreadDemo10 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //此方法只有第一次是true ,剩下的就置位false,感知到一次,标志位就被清除了
                    //System.out.println(Thread.interrupted());
                    //此方法全部都是true,说明标志位没有被清除,仅仅是判定标志位,不会修改
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        };
        t.start();

        t.interrupt();
    }
}
