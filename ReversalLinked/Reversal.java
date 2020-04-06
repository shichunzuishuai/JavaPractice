package ReversalLinked;
//反转一个单链表
// [OJ链接](https://leetcode-cn.com/problems/reverse-linkedlist/description/)
public class Reversal {
    Node head;
    Node newHead = null;
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }
    //让cur走index - 1 步
    public Node foot(int index){
        Node cur = this.head;
        for(int i = 0; i < index - 1; i++){
            cur = cur.getNext();
        }
        return cur;
    }
    //插入到链表中的任意位置
    public void addIndex(int data,int index){
        Node node = new Node(data);
        if(index < 0 || index > size()){
            throw new RuntimeException("index位置不合理");
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        Node cur = foot(index);
        node.setNext(cur.getNext());
        cur.setNext(node);
    }
   //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    //得到链表的长度
    public int size(){
        int count = 0;
    Node cur = this.head;
        while(cur != null){
                count++;
                cur = cur.getNext();
        }
                return count;
    }
//打印链表的内容
public void display(){
        Node cur = this.head;
        while (cur != null){
        System.out.print(cur.getData() + " ");
        cur = cur.getNext();
        }
    }
    //反转单链表
    public Node reversal(){
        Node pre = null;
        Node cur = this.head;
        while(cur != null){
            Node curNex = cur.getNext();
            if(curNex == null){
                newHead = cur;
            }
            cur.setNext(pre);
            pre = cur;
            cur = curNex;
        }
        return newHead;
    }
    //反转打印
    public void display2(){
        Node cur = this.newHead;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
}
