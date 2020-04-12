package HasCycle;

/**
 *  给定一个链表，判断链表中是否有环。 [OJ链接]
 *  (https://leetcode-cn.com/problems/linked-listcycle/description/)
 */
public class HasCycle {
    Node head;
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
    //显示链表中的内容
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
    //判断是否有环
    public Boolean hasCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.getNext() == null){
            return false;
        }
        return true;
    }
    //构建一个环
    public void loop(){
        Node cur = this.head;
        while (cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(this.head.getNext());
    }
}
