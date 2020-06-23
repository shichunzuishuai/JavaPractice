import java.util.Stack;

public class stackRealizeQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        if(!stack2.isEmpty()){
            int top = stack2.pop();
            stack1.push(top);
        }
        stack1.push(node);
    }
    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException();
        }
        while (!stack1.isEmpty()){
            int res = stack1.pop();
            stack2.push(res);
        }
        return stack2.pop();
    }
}
