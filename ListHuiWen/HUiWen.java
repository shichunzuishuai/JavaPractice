package ListHuiWen;

public class HUiWen {
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
    //先找到中间的节点
    public Node midNode(Node fast, Node slow){
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }
    //反转中间节点后的链表,在判断
    public Boolean reserve(){
        Node fast = this.head;
        Node slow = this.head;
        slow = midNode(fast,slow);
        Node cur = slow.getNext();
        while (cur != null) {
            Node curNext = cur.getNext();
            cur.setNext(slow);
            slow = cur;
            cur = curNext;

        }
        while (slow != this.head) {
            if(slow.getData() != this.head.getData()) {
                return false;
            }
            //偶数情况的判断
            if(this.head.getNext() == slow) {
                return true;
            }
            slow = slow.getNext();
            this.head = this.head.getNext();
        }
        return true;

    }


    //打印链表中的内容
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
}
