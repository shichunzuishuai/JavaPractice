package collectionFramework;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        //1.实例化一个对象
        Map<String,String> map = new HashMap<>();
        //2.isEmpty/size
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        //3.put若干个键值对,key=>val
        map.put("及时雨","宋江");
        map.put("智多星","吴用");
        map.put("行者","武松");
        //map.put("豹子头","李逵");
        //4.使用get,根据key找到val
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("智多星"));
        //找到key,返回对应的val,如果没找到,返回默认值
        System.out.println(map.getOrDefault("豹子头","林冲"));
        //5.使用contains判定元素是否存在 , key 和 val
        //containsKey比较高效
        System.out.println("======");
        boolean ret = map.containsKey("智多星");
        boolean ret2 = map.containsValue("吴用");
        System.out.println(ret);
        System.out.println(ret2);
        //循环遍历map,此时的Entry表示条目,表示一个一个的键值对
        //对于Map来说,保存的元素的顺序和插入的顺序没有关系
        //Map内部对于元素顺序有自己的规则
        for (Map.Entry<String, String> entry : map.entrySet()
        ){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //6.清空所有元素
        System.out.println("清空元素");
        map.clear();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }





}
