package queue;


public class MyQueue {
    //实现队列可以用链表也可以用顺序表,链表实现简单一些
    //链表的头节点作为队首,尾节点作为队尾
    //为了方便,可以引进一个尾节点
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

    Node head = new Node(-1);//头节点
    Node cur = head;//尾节点
     //private int size;
    //入队列,先进先出,所以采用尾插法
    public void offer(int val){
        Node node = new Node(val);
        cur.next = node;
        cur = cur.next;
    }
    //出队列,获取队首的元素
    public Integer poll(){
        if(head.next == null){
            return null;
        }
        Node toDelete = head.next;
        head.next = toDelete.next;
        //如果要删除的就是尾节点,删除之后要更新为节点的位置
        if(head.next == null){
            cur = head;
        }
        return toDelete.getVal();
    }

    //查看队首元素
    public Integer peek(){
        if(head.next == null){
            return null;
        }
        return head.next.getVal();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        while (true){
           Integer cur = myQueue.poll();
           if(cur == null){
               break;
           }
            System.out.println(cur);
        }
//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.poll());


    }


}
