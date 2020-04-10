package ListHuiWen;

public class TestDemo {
    public static void main(String[] args) {
        HUiWen h = new HUiWen();
        h.addFirst(10);
        h.addFirst(20);
        h.addFirst(30);
        h.addFirst(20);
        h.addFirst(10);
        h.display();
        Boolean ret = h.reserve();
        System.out.println(ret);
    }
}
