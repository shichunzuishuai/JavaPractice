/**
 * 链接：https://www.nowcoder.com/questionTerminal/03ba8aeeef73400ca7a37a5f3370fe68
 * 来源：牛客网
 *
 * 输入描述:
 *
 * 先输入字典中单词的个数n，再输入n个单词作为字典单词。
 *
 * 再输入一个单词，查找其在字典中兄弟单词的个数m
 *
 * 再输入数字k
 *
 *
 * 输出描述:
 *
 * 根据输入，输出查找到的兄弟单词的个数m
 * 然后输出查找到的兄弟单词的第k个单词。
 */

import java.util.*;
public class BrotherWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String str = scanner.nextLine();
            String[] arr = scanner.nextLine().split(" ");
            int a = scanner.nextInt();
            print(n,arr,a);
        }
    }
    public static void print(int n,String[] arr,int a){
        if(n == 0){
            return;
        }
        List<String> list = new ArrayList<>();
//        String[] res = new String[a];
//        int x = 0;
        Set<Character> set = new HashSet<>();
        String str1 = arr[arr.length - 1];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            set.add(c);
        }
        //遍历所有的字符串
        for (int i = 0; i < arr.length - 1; i++) {
            String str2 = arr[i];
            //现在比较两个字符串是不是兄弟
            if(str1.length() != str2.length()){
                continue;
            }else {
                for (int j = 0; j < str2.length(); j++) {
                    char c = str2.charAt(j);
                    if(!set.contains(c)){
                        continue;
                    }
                }
                //到这一步说明str1和str2的数量一样,并且str2的字母和str1一样
                boolean f = false;
                for (int k = 0; k < str1.length(); k++) {
                    char c = str1.charAt(k);
                    char d = str2.charAt(k);
                    if(c != d) {
                        f = false;
                        break;
                    }else {
                        f = true;
                    }
                }
                if(f == false){
                    list.add(str2);
                }
//                if(x == a - 1){
//                    break;
//                }
//                res[x++] = str2;
            }
        }
        Collections.sort(list);
        if(list.size() == 0){
            System.out.println("0");
        }
        if(list.size() >= a){
            System.out.println(list.size() + " " + list.get(a - 1));
        }else {
            System.out.println(list.size());
        }


//        Arrays.sort(res);
//        System.out.println(Arrays.toString(res));
    }
}
