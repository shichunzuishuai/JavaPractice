package MidNode;

/**
 *  给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *  如果有两个中间结点，则返回第二个中间结点。[OJ
 * 链接](https://leetcode-cn.com/problems/middle-of-the-linked-list/description/)

 */

public class MidNode {
    Node head;
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        node.setNext(head);
        this.head = node;
    }
    //显示链表中的数据
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
    //返回中间节点
    public Node midNode(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}
