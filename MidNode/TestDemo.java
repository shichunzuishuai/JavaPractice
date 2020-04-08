package MidNode;
public class TestDemo {
    public static void main(String[] args) {
        MidNode m = new MidNode();
        m.addFirst(10);
        m.addFirst(20);
        m.addFirst(30);
        m.display();
        Node ret = m.midNode();
        System.out.println(ret.getData());
    }
}
