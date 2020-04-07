package Partition;

/**
 * 6. 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。[OJ链接]
 * (https://www.nowcoder.com/practice/0e27e0b064de4eacac178676ef9c9d70?
 * tpId=8&&tqId=11004&rp=2&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/questionranking)
 */
public class Partition {
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
    public void display1(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }
    public void display2(Node newHead){
        Node cur = newHead;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }
    //按k值分割链表
    public Node partition(int x){
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null){
            if(cur.getData() < x){
                if(bs == null){
                    bs = cur;
                    be = bs;
                }else {
                    be.setNext(cur);
                    be = be.getNext();
                }
            }else{
                if(as == null){
                    as = cur;
                    ae = as;
                }else {
                    ae.setNext(cur);
                    ae = ae.getNext();
                }
            }
            cur = cur.getNext();
        }
        if(bs == null){
            return as;
        }
        be.setNext(as);
        if(as != null){
            ae.setNext(null);
        }
        return bs;
    }
}
