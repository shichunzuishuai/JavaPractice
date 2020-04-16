package DetectCycle;

public class TestDemo {
    public static void main(String[] args) {
        DetectCycle d = new DetectCycle();
        d.addFirst(10);
        d.addFirst(20);
        d.addFirst(30);
        d.addFirst(40);
        d.addFirst(50);
        d.addFirst(60);
        d.display();
        System.out.println();
        d.loop();
        Node ret = d.detectCycle();
        System.out.println(ret.getData());
    }
}
