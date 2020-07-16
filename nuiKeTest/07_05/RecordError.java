/**
 * 链接：https://www.nowcoder.com/questionTerminal/2baa6aba39214d6ea91a2e03dff3fbeb
 * 来源：牛客网
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 * 示例1
 * 输入
 * E:\V1R2\product\fpgadrive.c   1325
 * 输出
 * fpgadrive.c 1325 1
 */

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecordError{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (scanner.hasNext()){
            String str = scanner.next();
            int num = scanner.nextInt();
            String[] arr = str.split("\\\\");
            String a = arr[arr.length - 1];
            if(a.length() > 16){
                a = a.substring(a.length() - 16);
            }
            String key = a + " " + num;
            int val = 1;
            if(map.containsKey(key)){
                map.put(key,map.get(key) + 1);
            }else {
                map.put(key,val);
            }
        }
        int count = 0;
        for (String s : map.keySet()) {
            count++;
            if(count>(map.keySet().size() - 8)){
                System.out.println(s + " " + map.get(s));
            }
        }
    }
}