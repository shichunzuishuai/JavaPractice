package collectionFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //1.size/isEmpty
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        //2.添加元素
        list.add("java");
        list.add("C++");
        list.add("python");
        list.add("c语言");
        //打印整个list
        System.out.println(list);
        //使用下标访问
        System.out.println("========");
        System.out.println(list.get(0));
        list.set(0,"linux");
        System.out.println(list.get(0));
        System.out.println(list);
        //截取部分内容
        System.out.println(list.subList(1,3));
        //重新构造一个list(浅拷贝)
        List<String> arrayList = new ArrayList<>(list);
        List<String> linkedList = new ArrayList<>(list);
        System.out.println(arrayList);
        System.out.println(linkedList);
        //基于现有的list进行强制转换(向下转型)
        System.out.println("向下转型");
        ArrayList<String> arrayList1 = (ArrayList) list;
        //现有的list不是linkedList类型,强转会出错
        //LinkedList<String> linkedList1 = (LinkedList)list;


    }
}
