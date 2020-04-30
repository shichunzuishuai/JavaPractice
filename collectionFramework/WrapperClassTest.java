package collectionFramework;

import java.util.*;

public class WrapperClassTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //内置类型转成包装类
//        Integer i = Integer.valueOf(10);
//        Integer i2 = new Integer(10);
        Integer i = 10;//自动装箱
        //包装类=>内置类型
       // int j = i.intValue();
        int j = i;//自动拆箱
    }
}
