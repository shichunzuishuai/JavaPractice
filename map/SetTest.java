package map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //1.add添加元素,如果set中有多个相同元素,最终set中只有一份,去重
        set.add("java");
        set.add("c++");
        set.add("JS");
        set.add("python");
        //2.判定某个元素是否在set中
        System.out.println(set.contains("java"));
        //3.set还可以删除元素
        set.remove("c++");
        System.out.println(set.contains("c++"));
        //4.打印set的元素
        System.out.println(set);
        //5.遍历打印,set/map中的元素顺序和add,put的顺序无关.
        for (String s: set) {
            System.out.println(s);
        }
        //6.使用迭代器遍历集合
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
