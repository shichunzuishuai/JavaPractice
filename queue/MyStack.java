package queue;

public class MyStack {
    //用顺序表写栈
    private int[] arr = new int[100];
    private int size = 0;
    //arr[0]相当于栈底,arr[size - 1]相当于栈顶
    public void push(int val){
        if(size >= arr.length){
            throw new RuntimeException("栈满了");
        }
        arr[size] = val;
        size++;

    }
    //弹出到栈顶的元素
    public Integer pop(){
        if(size <= 0){
            return null;
        }
        Integer ret = arr[size - 1];
        size--;
        return ret;
    }
    //查看栈顶的元素
    public Integer peek(){
        if(size <= 0){
            return null;
        }
        return arr[size - 1];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (true){
            Integer cur = stack.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
    }
}
