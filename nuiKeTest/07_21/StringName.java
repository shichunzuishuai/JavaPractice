/**
 * 骆驼命名法
 * 例
 * 输入: dsa_ds
 * 输出: dsaDs
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[100];
        while (scanner.hasNext()){
            int i = 0;
            arr[i ++] = scanner.nextLine();
            print(arr);
        }
    }
    public static void print(String[] arr){
        List<String> list = new ArrayList<>();
        String ret = "";
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null){
                break;
            }
            String str = arr[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(c == '_'){
                   char d = Character.toUpperCase(str.charAt(j + 1));
                   ret += d;
                   j++;
                }else {
                    ret += c;
                }
            }
          list.add(ret);
            ret = "";
        }
        for (String s: list) {
            System.out.println(s);
        }
    }
}
