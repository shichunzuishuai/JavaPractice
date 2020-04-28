package collectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {
        //1.Collection是一个接口,必须new一个对应的类来实例化对象
        Collection<String> collection = new ArrayList<>();
        //2.使用size和isEmpty
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        System.out.println("===========");
        //3.使用add添加元素
        collection.add("我");
        collection.add("爱");
        collection.add("java");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        System.out.println(collection);
        //4.使用toArray把集合转成数组
        Object[] arr = collection.toArray();
        System.out.println(Arrays.toString(arr));
        //5.for each遍历集合
        System.out.println("===========");
        for (String s:collection
             ) {
            System.out.println(s);
        }
        //6.判断collection中是否包含元素
        boolean ret = collection.contains("爱");
        System.out.println(ret);
        //7.删除指定元素
        System.out.println("=====");
        collection.remove("爱");
        for (String s:collection
             ) {
            System.out.println(s);
        }
        //8.清空所有元素
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.isEmpty());
    }
}
