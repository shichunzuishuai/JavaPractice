package my_arrayList;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        MyArrayList m = new MyArrayList();
        for(int i = 0; i < 10; i++){
            m.add(i,i);
        }
        m.display();
        System.out.println();
        m.add(10,100);
        m.display();
        System.out.println();
        System.out.println(m.contains(9));
        System.out.println(m.search(8));
        System.out.println(m.getPos(10));
        m.remove(100);
        m.display();
    }
}
