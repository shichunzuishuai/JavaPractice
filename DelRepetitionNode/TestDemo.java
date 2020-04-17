package DelRepetitionNode;
public class TestDemo {
    public static void main(String[] args) {
        DelNode d = new DelNode();
        d.addLast(10);
        d.addLast(15);
        d.addLast(20);
        d.addLast(20);
        d.addLast(30);
        d.addLast(40);
        Node ret = d.delNode();
        System.out.println(ret.getData());
        d.display();
    }


}
