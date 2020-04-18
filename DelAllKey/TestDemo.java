package DelAllKey;

public class TestDemo {
    public static void main(String[] args) {
        DelKey d = new DelKey();
        d.addFirst(10);
        d.addFirst(20);
        d.addFirst(20);
        d.addFirst(20);
        d.addFirst(20);
        d.delAllKey(20);
        d.display();
    }
}
