package queue;

public class MyQueue2 {
    //用顺序表实现队列
    private int[] arr = new int[100];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    //判断是否成功插入,如果达到了顺序表的长度,则插入失败
    public boolean offer(int val){
        if(size == arr.length){
            return false;
        }
        arr[tail] = val;
        tail++;
        if(tail >= arr.length){
            tail = 0;
        }
        //tail = tail % arr.length;
        size++;
        return true;
    }
    //取出第一个元素
    public Integer poll(){
        if(size == 0){
            return null;
        }
        int cur = arr[head];
        head++;
        if(head >= arr.length){
            head = 0;
        }
        size--;
        return cur;
    }
    //查看第一个元素
    public Integer peek(){
        if(size == 0){
            return null;
        }
        return arr[head];
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);
        while (true){
            Integer ret = myQueue2.poll();
            if(ret == null){
                break;
            }
            System.out.println(ret);
        }
//        System.out.println(myQueue2.poll());
//        System.out.println(myQueue2.poll());
//        System.out.println(myQueue2.poll());
//        System.out.println(myQueue2.peek());
//        System.out.println(myQueue2.poll());
    }

}
