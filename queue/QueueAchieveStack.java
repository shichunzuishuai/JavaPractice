package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */

public class QueueAchieveStack {
    Queue<Integer> A = new LinkedList<>();
    Queue<Integer> B = new LinkedList<>();
    public QueueAchieveStack(){

    }
    //将要插入的值放进A中
    public void push(int val){
        A.offer(val);
    }
    //弹出时先把A中的元素放进B中,只剩下一个的时候弹出,然后交换A,B的值即可
    public int pop(){
        if(empty()){
            return 0;
        }
        while (A.size() > 1){
            int ret = A.poll();
            B.offer(ret);
        }
        int top = A.poll();
        swap();
        return top;
    }
    //判断A,B是否为空
    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
    //交换A,B
    public void swap(){
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }
    //获取到栈顶元素
    public int top(){
        if(empty()){
            return 0;
        }
        while (A.size() > 1){
            int ret = A.poll();
            B.add(ret);
        }
        int topVal = A.poll();
        B.offer(topVal);
        swap();
        return topVal;
    }

    public int size1(){
        return A.size();
    }



    public static void main(String[] args) {
        QueueAchieveStack q = new QueueAchieveStack();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
//        int val = q.pop();
//        System.out.println(val);
        while (true){
            int val = q.pop();
            if(val == 0){
                break;
            }
            System.out.println(val);
        }
        //System.out.println(q.size1());
    }
}
