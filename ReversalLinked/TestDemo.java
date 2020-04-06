package ReversalLinked;

public class TestDemo {
    public static void main(String[] args) {
        Reversal reversal = new Reversal();
        reversal.addFirst(10);
        reversal.addFirst(20);
        reversal.addFirst(30);
        reversal.addFirst(40);
        reversal.addFirst(50);
        reversal.addIndex(70,0);
        reversal.addLast(100);
        reversal.display();
        System.out.println();
        reversal.reversal();
        reversal.display2();
    }
}
