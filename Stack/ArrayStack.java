package Stack;

public class ArrayStack {
    private int maxsize;
    private int[] stack;
    private int top = -1;
    public ArrayStack(int maxsize){
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }
    public void list(){
        if(IsEmpty()){
            System.out.println("栈空,没有数据");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
    public boolean IsFull(){
        return top == maxsize - 1;
    }
    public boolean IsEmpty(){
        return top == -1;
    }
    public void push(int val){
        if(IsFull()){
            System.out.println("栈满,不能存放数据");
            return;
        }
        top ++;
        stack[top] = val;
    }
    public int pop(){
        if(IsEmpty()){
            throw new RuntimeException("栈空,没有数据");
        }
        int val = stack[top];
        top--;
        return val;
    }



}
