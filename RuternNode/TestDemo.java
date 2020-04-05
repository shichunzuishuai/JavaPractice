package RuternNode;

public class TestDemo {
    public static void main(String[] args) {
        ReturnNode r = new ReturnNode();
        r.addFirst(10);
        r.addFirst(20);
        r.addFirst(30);
        r.addFirst(40);
        r.display();
        System.out.println();
//        int ret = r.size();
//        System.out.println(ret);
        Node ret = r.returnNode(3);
        System.out.println(ret.getData());
    }
}
