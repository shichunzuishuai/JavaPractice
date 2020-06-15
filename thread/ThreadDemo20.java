package thread;
//对象等待集,wait notify
//wait 必须先释放锁,所以必须搭配synchronized使用,  否则:Exception in thread "main" java.lang.IllegalMonitorStateException
public class ThreadDemo20 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("等待前");
            object.wait();
            System.out.println("等待后");
        }
    }
}
