package thread_review;

public class ThreadDemo02 {
    private static boolean isQuite = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (!isQuite){
                    System.out.println("忙着转账呢");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        Thread.sleep(5000);
        isQuite = true;
        System.out.println("终止交易");
    }
}
