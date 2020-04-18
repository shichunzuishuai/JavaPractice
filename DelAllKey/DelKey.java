package DelAllKey;
/**
 *  删除链表中等于给定值 **val** 的所有节点。
 *  [OJ链接](https://leetcode-cn.com/problems/removelinked-list-elements/description/)
 */

public class DelKey {
    public Node head;
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
    //删除所有key的值
    public void delAllKey(int key){
        Node cur = head.getNext();
        Node pre = head;
        while (cur != null){
            if(cur.getData() == key){
                pre.setNext(cur.getNext());
                cur = cur.getNext();
            }else{
                cur = cur.getNext();
                pre = pre.getNext();
            }
        }
        if(this.head.getData() == key){
            this.head = this.head.getNext();
        }
    }
    //大打印链表中的内容
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
}
