package thread_review;

public class ThreadDemo03 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("忙着转账呢");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("转账被终止");
            }
        };
        t.start();
        Thread.sleep(5000);
        System.out.println("终止交易");
        t.interrupt();
    }
}
