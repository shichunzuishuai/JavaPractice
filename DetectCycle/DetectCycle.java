package DetectCycle;

/**
 * 11. 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * [OJ链接](https://leetcodecn.com/problems/linked-list-cycle-ii/description/)
 */
public class DetectCycle {
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
    //返回入环的第一个节点
    public Node detectCycle(){
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
            return null;
        }
        slow = head;
        while (fast != slow){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return fast;
    }
    //制造循环
    public void loop(){
       Node cur = this.head;
       while (cur.getNext() != null){
           cur = cur.getNext();
       }
       cur.setNext(this.head.getNext());
    }
}
