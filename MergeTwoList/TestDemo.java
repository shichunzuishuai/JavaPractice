package MergeTwoList;

public class TestDemo {
    public static void main(String[] args) {
        MergeTwoList m1 = new MergeTwoList();
        m1.addFirst(40);
        m1.addFirst(30);
        m1.addFirst(20);
        m1.addFirst(10);
        m1.display();
        System.out.println();
        MergeTwoList m2 = new MergeTwoList();
        m2.addFirst(90);
        m2.addFirst(80);
        m2.addFirst(30);
        m2.addFirst(20);
        m2.display();
        System.out.println();
        Node ret = merge(m1.head,m2.head);
        m2.display2(ret);

    }
    //合并两个链表
    public static Node merge(Node m1,Node m2 ){
        Node newHead = new Node(-1);
        Node cur = newHead;
        while (m1 != null && m2 != null){
            if(m1.getData() < m2.getData()){
                cur.setNext(m1);
                cur = cur.getNext();
                m1 = m1.getNext();
            }else{
                cur.setNext(m2);
                cur = cur.getNext();
                m2 = m2.getNext();
            }

        }
        if(m1 != null){
            cur.setNext(m1);
        }
        if(m2 != null){
            cur.setNext(m2);
        }
        return newHead.getNext();
    }
}
