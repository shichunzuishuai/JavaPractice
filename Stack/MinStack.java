package Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        A.push(x);
        if(B.empty()){
            B.push(x);
            return;
        }
        int min = B.peek();
        if(x < min){
            min = x;
        }
        B.push(min);
    }

    public void pop() {
        if(A.empty()){
            return;
        }
        A.pop();
        B.pop();
    }

    public int top() {
        if(A.empty()){
            return 0;
        }
        return A.peek();
    }

    public int getMin() {
        if(B.empty()){
            return 0;
        }
        return B.peek();
    }
}
