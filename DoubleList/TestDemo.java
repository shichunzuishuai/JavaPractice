package DoubleList;

public class TestDemo {
    public static void main(String[] args) {
        DoubleListNode d = new DoubleListNode();
        d.addLast(10);
        d.addLast(20);
        d.display();
        System.out.println();
        d.addIndex(1,30);
        d.display();
    }
}
