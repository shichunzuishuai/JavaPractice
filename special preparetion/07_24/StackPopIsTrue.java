/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * //OJ链接：https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?
 * tpId=13&tqId=11174&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路： //要判定第二个序列是否可能是该栈的弹出序列，就要使用指定的入栈顺序
 * //模拟出来对应的弹栈序列，我们设入栈顺序序列式pushV，
 * 可能出栈序列popV //popv的第一个元素，一定是最后入栈，最先弹栈的,而我们的入栈顺序是一定的
 * //也就决定了，我们必须一直入栈，直到碰到popv的第一个元素，然后开始弹栈 //最后在循环这个过程，
 * 如果符合要求，最后栈结构一定是空的
 */

import java.util.Stack;
public class StackPopIsTrue {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null ||popA == null ||pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack();
        int j = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}