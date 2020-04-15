package doubleHeadList;

public class TestDemo {
    public static void main(String[] args) {
        DoubleHeadList d = new DoubleHeadList();
        d.addFirst(10);
        d.addFirst(20);
        d.addFirst(30);
        d.addFirst(40);
        d.addLast(10);
        d.addLast(100);
        d.addLast(100);
        d.addFirst(20);
        d.addLast(20);
//        d.addIndex(20,3);
//        d.addIndex(20,5);
        d.addIndex(90,2);
        d.display();
        //测试链表的长度
        int ret = d.size();
        System.out.println(ret);
       // 测试链表是否包含key
        //Boolean ret = d.contains(80);
        //System.out.println(ret);
        //删除第一次出现的key
        //d.remove(100);
        //d.display();
        //删除链表中所有的key值
        d.removeAllKey(20);
        d.display();
        //清空链表
        d.clean();
        System.out.println("hello");
        d.display();
    }

}
