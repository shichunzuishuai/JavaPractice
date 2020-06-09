package thread;


public class ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                //此处使用Thread内部的标志位来进行判定
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("我正忙着转账呢");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("转账操作结束");
            }
        };
        t.start();
        Thread.sleep(5000);
        System.out.println("有内鬼,终止交易");
        t.interrupt();
    }
}
