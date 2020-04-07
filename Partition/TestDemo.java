package Partition;

public class TestDemo {
    public static void main(String[] args) {
        Partition p = new Partition();
        p.addFirst(6);
        p.addFirst(3);
        p.addFirst(1);
        p.addFirst(5);
        p.addFirst(2);
        p.display1();
        Node newHead = p.partition(4);
        p.display2(newHead);
    }
}
