package queue;

public class MyStack2 {
    //用链表写一个栈
    //链表的头部表示栈的栈顶,链表的尾部表示栈的栈底

    static class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    //创建一个傀儡头节点
    Node head = new Node(-1);
    //栈是先进后出,所以应该采用头插和头删
    public void push(int val){
         Node node = new Node(val);
         node.next = head.next;
         head.next = node;
    }
    //获取到头节点的值并删除头节点
    public Integer pop(){
        Node delNode = head.next;
        if(delNode == null){
            return null;
        }
        head.next = delNode.next;
        return delNode.getVal();
    }
    //获取头节点的值不删除头节点
    public Integer peek(){
        if(head.next == null){
            return null;
        }
        int val = head.next.getVal();
        return val;
    }

    public static void main(String[] args) {
        MyStack2 stack2 = new MyStack2();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        while (true){
            Integer cur = stack2.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
    }

}
