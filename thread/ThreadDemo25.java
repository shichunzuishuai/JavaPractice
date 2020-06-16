package thread;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo25 {
    // 优先队列中的元素必须是可比较的~
    // 比较规则的指定主要是两种方式:
    // 1. 让 Task 实现 Comparable 接口
    // 2. 让优先队列构造的时候, 传入一个比较器对象 (Comparator).
    static class Task implements Comparable<Task> {
        // Runnable 中有一个 run 方法, 就可以借助这个 run 方法来描述要执行的具体的任务是啥.
        private Runnable command;
        private long time;
        // 构造方法的参数表示: 多少毫秒之后执行. (相对时间) 这个相对时间的参数是为了用起来方便
        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }
        //执行任务的具体逻辑
        public void run(){
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            // 谁的时间小(先执行)
            return (int) (this.time - o.time);
        }
    }
    static class Worker extends  Thread{
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;

        public Worker(PriorityBlockingQueue<Task> queue, Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            //实现具体的执行内容
            while (true){
                try {
                    Task task = queue.take();
                    long curTime = System.currentTimeMillis();
                    if(task.time > curTime){
                        //时间还没到,把任务继续塞回阻塞队列中
                        queue.put(task);
                        synchronized (mailBox){
                            mailBox.wait(task.time - curTime);
                        }
                    }else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }


    static class Timer{
        // 为了避免忙等, 需要使用 wait 方法.
        // 使用一个单独的对象来辅助进行 wait
        // 使用 this 也行.
        private Object mailBox = new Object();
        // 定时器的基本构成, 有三个部分.
        // 1. 用一个类来描述 "任务"
        // 2. 用一个阻塞优先队列来组织若干个任务. 让队首元素就是时间最早的任务.
        // 如果队首元素时间未到, 那么其他元素也肯定不能执行.
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        //3.使用一个线程来循环扫描阻塞队列的队首,如果时间到,就执行指定的任务
        public Timer(){
           Worker worker = new Worker(queue,mailBox);
           worker.start();

        }
        public void Schedule(Runnable command,long after){
            Task task = new Task(command,after);
            queue.put(task);
            synchronized (mailBox){
                mailBox.notify();
            }

        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.Schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hehe");
                timer.Schedule(this,2000);
            }
        },500);

    }
}
