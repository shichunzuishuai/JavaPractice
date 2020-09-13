/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsValid {
//    public static boolean isValid(String s) {
//        Stack stack1 = new Stack();
//        Queue queue = new LinkedList();
//        for(int i = 0; i <s.length(); i++){
//            char c = s.charAt(i);
//            if(c =='(' || c == '[' || c == '{'){
//                stack1.push(c);
//            }else if(c == ')' || c == ']' || c == '}'){
//                queue.add(c);
//            }
//        }
//        if(stack1.size() != queue.size()){
//            return false;
//        }
//        while (!stack1.isEmpty()){
//            char a = (char)stack1.pop();
//            char b = (char)queue.poll();
//            if((a == '(' && (b == ']' ||b =='}')) || (a == '[' && (b == ')' || b == '}')) ||
//            (a == '{' && (b == ']' ||b ==')'))){
//                return false;
//            }
//        }
//        return true;
//    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() %2 != 0){
            return false;
        }
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        boolean ret = isValid(s);
        System.out.println(ret);
    }
}
