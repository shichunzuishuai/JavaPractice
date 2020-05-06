package queue;

import java.util.Stack;

/**
 * 用栈实现队列
 */

public class StackAchieveQueue {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
//要保证所有的元素都在A中,然后再把VAL插入到B中
    public void push(int val){
        if(!B.isEmpty()){
            Integer top = B.pop();
            A.push(top);
        }
        A.push(val);
    }
    //弹出的时候把A中所有的元素都放进B中,然后依次弹出即可
    public int pop(){
        if(empty()){
            return 0;
        }
        while (!A.isEmpty()){
            int ret = A.pop();
            B.push(ret);
        }
        return B.pop();
    }

    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
    //获取队首元素
    public int topVal(){
        if(empty()){
            return 0;
        }
        while (!A.isEmpty()){
            int ret = A.pop();
            B.push(ret);
        }
        return B.peek();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (true){
            int val = s.pop();
            if(val == 0){
                break;
            }
            System.out.println(val);
        }
    }
}
