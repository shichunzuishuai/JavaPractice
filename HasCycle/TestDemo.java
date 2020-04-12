package HasCycle;

public class TestDemo {
    public static void main(String[] args) {
        HasCycle h = new HasCycle();
        h.addFirst(10);
        h.addFirst(20);
        h.addFirst(30);
        h.addFirst(40);
        h.addFirst(50);
        h.addFirst(60);
        h.display();
        h.loop();
        System.out.println(h.hasCycle());
    }

}
