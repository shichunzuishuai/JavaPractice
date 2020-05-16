package map;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            //1.处理输入,读取输入值
            String expend = scanner.next();
            String actual = scanner.next();
            //2.把输入和输出都转换成大写
            expend = expend.toUpperCase();
            actual = actual.toUpperCase();
            //3.把actual中的字符都放进一个set钟
            Set<Character> set =new HashSet<>();
            for(int i = 0; i < actual.length(); i++){
                set.add(actual.charAt(i));
            }
            //4.遍历expend中的字符,和set进行对比,如果set中出现,说明此键不是坏的
            //反之是坏的
            Set<Character> brokenMap = new HashSet<>();
            for(int i = 0; i < expend.length(); i++){
                Character c = expend.charAt(i);
                if(set.contains(c)){
                    continue;
                }
                if(brokenMap.contains(c)){
                    continue;
                }
                System.out.print(c);
                brokenMap.add(c);
            }

        }
    }
}
