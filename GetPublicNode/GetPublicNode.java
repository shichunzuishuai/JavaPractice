package GetPublicNode;

public class GetPublicNode {
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
        System.out.println();
    }

}
