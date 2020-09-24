package BiShi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuaHUa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();
        int ret = color(strA,strB);
        System.out.println(ret);
    }
    public static int color(String strA, String strB){
        if(strA == null || strA.length() == 0){
            return 0;
        }
       Map<Character,Integer> map = new HashMap();
       for(int i = 0; i < strA.length(); i++){
           char c = strA.charAt(i);
           if(map.containsKey(c)){
               Integer count = map.get(c);
                   map.put(c,count+1);
           }else {
               map.put(c,1);
           }
       }
       int ret = 0;
       for(int j = 0; j <strB.length();j++){
           char c = strB.charAt(j);
           if(map.containsKey(c)){
               int count = map.get(c);
               map.put(c,count-1);
               ret++;
               if(map.get(c) == 0){
                   map.remove(map.get(c));
               }
           }
       }
       return ret;
    }
}
