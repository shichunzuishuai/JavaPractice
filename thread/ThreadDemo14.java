package thread;
//获取线程在某一时刻的运行状态
public class ThreadDemo14 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100_00; i++) {
                    
                }
            }
        };
        System.out.println("这是线程启动之前的状态" + t.getState());
        t.start();
        while (t.isAlive()){
            System.out.println("这是线程正在运行时的状态" + t.getState());
        }
        System.out.println("这是线程结束之后的状态" + t.getState());
    }
}
