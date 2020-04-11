package LinkedList;
public class TestDemo {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addFirst1(10);
        l.addFirst1(20);
        l.addLast(30);
        l.addIndex(1,40);
        l.addLast(40);
        l.addFirst1(40);
        //boolean ret = l.contains(70);
        //System.out.println(ret);
        l.del(30);
        l.removeAllKey(40);
        l.display();
    }
}
