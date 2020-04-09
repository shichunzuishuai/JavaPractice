package MergeTwoList;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * [OJ链接]
 * (https://leetcode-cn.com/problems/merge-two-sorted-lists/description/)
 */
public class MergeTwoList {
    public Node head;
    public Node newHead;
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
    //显示链表种的内容
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
    public void display2(Node newHead){
        Node cur = newHead;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }

}
