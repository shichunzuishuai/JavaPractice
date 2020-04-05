package RuternNode;

/**
 * 4. 输入一个链表，输出该链表中倒数第k个结点。 [OJ链接]
 * (https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?
 * tpId=13&&tqId=11167&rp=2&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking)
 * 5.
 */
public class ReturnNode {
    Node head;
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(head == null){
            this.head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }
    //定义一个cur,让它先走k - 1 步
    public Node feet(Node cur,int k){
        if(k < 0 || k > size()){
            return null;
        }
        for(int i = 0; i < k -1; i++){
            cur = cur.getNext();
        }
        return cur;
    }
    //找到倒数第k个链表
    public Node returnNode(int k){
        Node cur = this.head;
        Node slow = this.head;
        cur = feet(cur,k);
        while (cur.getNext() != null){
            cur = cur.getNext();
            slow = slow.getNext();
        }
        return slow;

    }
    //显示链表中的内容
    public void display(){
        Node cur = head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
    //求链表的长度
    public int size(){
        int count = 0;
        Node cur = this.head;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
}
