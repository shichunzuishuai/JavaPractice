package thread;


public class ThreadDemo24 {
    static class BlockingQueue{
        private int[] arr = new int[1000];
        private volatile int  head = 0;
        private volatile int tail = 0;
        //head 和tail构成一个前闭后开的区间
        //head 和 tail重合时极可能数组为空,也可能满了
        private volatile int size = 0;
        // 队列的基本操作
        // 1. 入队列
        // 2. 出队列
        // 3. 取队首元素
        // 针对阻塞队列来说, 只提供前两个操作, 不支持取队首元素.

        //阻塞版的入队列
        public void put(int val) throws InterruptedException {
            //把val放到队尾即可
            synchronized (this) {
                while (size == arr.length){
                    wait();
                }
                arr[tail] = val;
                tail++;
                if(tail == arr.length){
                    tail = 0;
                }
                size++;
                notify();
            }
        }
        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                while (size == 0){
                    wait();
                }
                ret = arr[head];
                head++;
                if(head == arr.length){
                    head = 0;
                }
                size--;
                notify();
            }
            return ret;
        }
    }


    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        // 搞两个线程, 分别模拟生产者和消费者.
        // 第一次, 让给消费者消费的快一些, 生产者生产的慢一些.
        // 此时就预期看到, 消费者线程会阻塞等待. 每次有新生产的元素的时候, 消费者才能消费
        // 第二次, 让消费者消费的慢一些, 生产者生产的快一些.
        // 此时就预期看到, 生产者线程刚开始的时候会快速的往队列中插入元素, 插入满了之后就会阻塞等待.
        // 随后消费者线程每次消费一个元素, 生产者才能生产新的元素.
        Thread producer = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 2001; i++) {
                    try {
                        blockingQueue.put(i);
                        System.out.println("生产元素: " + i);
                        //Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();

        Thread custom = new Thread(){
            @Override
            public void run() {
               while (true){
                   try {
                       int ret = blockingQueue.take();
                       System.out.println("获取元素: " + ret);
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        };
        custom.start();
    }

}
