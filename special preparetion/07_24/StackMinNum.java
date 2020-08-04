/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * 解析：
 * //OJ链接：https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?
 * tpId=13&tqId=11173&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * //解题思路： //很容易想到，在栈内部保存min变量，每次更新的时候，都对min变量进行更新。
 * //但是，面试官很容易就会问到：如果想拿出第二小，第三小的值怎么拿？ //用上面的办法就不行了
 * //为了满足通用，我们使用一个辅助栈，
 * 内部保存元素的个数和数据栈完全一样，不过，辅助栈内部永远保存本次入栈的数为 所有数据的最小值
 * （注意：辅助栈内部元素可能会出现“必要性”重复） //我们这里是为了实现算法， 所以就不从0开始实现stack了
 * //题面说了，保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法，
 * 所以，后面的代码对空的检验可 有可无
 */

import java.util.Stack;
public class StackMinNum {
    Stack<Integer> st1 = new Stack<>();//标准栈
    Stack<Integer> st2 = new Stack<>();//辅助栈
        public void push(int node) {
            if(st2.empty() || node < st2.peek()){
                st2.push(node);
            }else {
                st2.push(st2.peek());
            }
            st1.push(node);
        }

        public void pop() {
            st1.pop();
            st2.pop();
        }

        public int top() {
            return st1.peek();
        }

        public int min() {
            return st2.peek();
        }
    }

