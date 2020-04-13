package GetPublicNode;

/**
 * 9. 输入两个链表，找出它们的第一个公共结点。[OJ链接]
 * (https://leetcode-cn.com/problems/intersectionof-two-linked-lists/description/)
 */
public class TestDemo {
    public static void main(String[] args) {
        GetPublicNode g1 = new GetPublicNode();
        g1.addFirst(10);
        g1.addFirst(20);
        g1.addFirst(30);
        g1.addFirst(40);
        g1.addFirst(98);
        g1.display();
        GetPublicNode g2 = new GetPublicNode();
        g2.addFirst(16);
        g2.addFirst(29);
        g2.addFirst(35);
        g2.addFirst(43);
        g2.display();
        createCut(g1.head,g2.head);
        g1.display();
        g2.display();
        Node ret = getNode(g1.head,g2.head);
        System.out.println(ret.getData( ));
    }
    //返回两个相交链表的共有节点
    public static Node getNode(Node headA,Node headB){
        int lena = 0;
        int lenb = 0;
        Node pl = headA;
        Node ps = headB;
        while (pl != null){
            lena++;
            pl = pl.getNext();
        }
        while (ps != null){
            lenb++;
            ps = ps.getNext();
        }
        pl = headA;
        ps = headB;
        int len = lena - lenb;
        if(len < 0){
            pl = headB;
            ps = headA;
            len = lenb - lena;
        }
        while (len > 0){
            pl = pl.getNext();
            len --;
        }
        while (pl != ps){
            pl = pl.getNext();
            ps = ps.getNext();
        }
        if(pl != null && ps != null && pl == ps){
            return pl;
        }
        return null;
    }
    //让两个链表相交
    public static void createCut(Node headA, Node headB){
        headA.setNext(headB.getNext().getNext());
    }
}
