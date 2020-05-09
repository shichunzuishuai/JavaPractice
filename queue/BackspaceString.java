package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 */
public class BackspaceString {
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> t1 = help(S);
        Stack<Character> t2 = help(T);
        int flag = 0;
        int size = t1.size();
        if(t1.size() != t2.size()){
            return false;
        }else {
            for(int i = 0; i < size; i++){
                int val1 = t1.pop();
                int val2 = t2.pop();
                if(val1!=val2){
                    flag = 1;
                }
            }
        }
        if(flag == 0){
            return true;
        }else{
            return false;
        }

    }
    public static Stack<Character> help(String s){
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }

        while (!queue.isEmpty()){
            char val = queue.poll();
            if(val != '#'){
                stack.add(val);
            }else if(val == '#' && !stack.isEmpty()){
                stack.pop();
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        String S = "abcd";
        String T = "ebcd";
        Boolean ret = backspaceCompare(S,T);
        System.out.println(ret);
    }

}
