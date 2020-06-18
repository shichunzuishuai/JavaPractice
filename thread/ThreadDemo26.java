package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadDemo26 {
    // 使用这个类来描述当前的工作线程是啥样的.
    static class  Worker extends Thread{
        // 每个 Worker 线程都需要从任务队列中取任务.
        // 需要能够获取到任务队列的实例
        private int id = 0;
        private BlockingQueue<Runnable> queue = null;
        public Worker(BlockingQueue<Runnable> queue,int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            try{
                while (!Thread.currentThread().isInterrupted()){
                    Runnable command = queue.take();
                    System.out.println("thread" + id + " run...");
                    command.run();
                }
            } catch (InterruptedException e) {
                System.out.println("线程被终止");
            }
        }
    }
    static class MyThreadPoll{
        //这个阻塞队列用于组织若干个任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        //这个list用于组织若干个线程
        private List<Worker> workers = new ArrayList<>();
        private static final int maxWorkerCount = 10;
        //实现execute方法和shutdown方法
        public void execute(Runnable command) throws InterruptedException {
            //也是用延时加载的方式来创建线程
            //当线程池中线程较少时,新创建线程来为线程池工作
            //当线程池中的线程数目较多时(已达到设定的阈值),就不新建线程了
            if(workers.size() < maxWorkerCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }
        //当shutDown方法执行结束时,所有的线程一定都结束了
        public void shutDown() throws InterruptedException {
            for (Worker worker: workers) {
                worker.interrupt();
            }
            //还需要等待每个线程执行结束
            for (Worker worker: workers ) {
                worker.join();
            }
        }
    }
    static class Commamd implements Runnable{
        private int num;
        public Commamd(int num){
            this.num = num;
        }
        @Override
        public void run() {
            System.out.println("正在执行任务" +num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPoll poll = new MyThreadPoll();
        for(int i = 0; i < 1000; i++){
            poll.execute(new Commamd(i));
        }
        Thread.sleep(2000);
        poll.shutDown();
        System.out.println("线程已被销毁");
    }
}
