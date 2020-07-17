/**
 *请编写一个方法，输出0到n(包括n)中数字2出现了几次。
 *
 * 给定一个正整数n，请返回0到n的数字中2出现了几次。
 *
 * 测试样例：
 * 10
 * 返回：1
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Statistics2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
           int res =  count2(n);
            System.out.println(res);
        }
    }
    //此方法超时
    public static int  count2(int n){
        Map<Integer,Integer> map = new HashMap<>();
        String str = "";
        for (int i = 1; i <= n; i++) {
            str += i;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                Integer count = map.get(2);
                if(c == '2'){
                    if(count == null){
                        map.put(2,1);
                    }else {
                        map.put(2,count+1);
                    }
                }
            }
            str = "";
        }
        return map.get(2);
    }
}
