import java.util.Stack;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/d281619e4b3e4a60a2cc66ea32855bfa
 * 来源：牛客网
 *
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 *
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 *
 * 测试样例：
 * 1->2->2->1
 * 返回：true
 */
public class ChkPalindrome {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public boolean chkPalindrome(ListNode A) {
        // write code here
        //方法一: 借助栈
        Stack<Integer> stack = new Stack<>();
        ListNode cur  = A;
        while (A != null){
            stack.push(A.val);
            A = A.next;
        }

        while (!stack.isEmpty()){
            int p = stack.pop();
            if(p != cur.val){
                return false;
            }else {
                cur = cur.next;
            }
        }
        return true;
    //方法二: 先反转单链表,在进行判断
//        ListNode p = reverseList(A);
//        while (A != null){
//            if(A.val != p.val){
//                return false;
//            }
//            p = p.next;
//            A = A.next;
//        }
//        return true;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = null;
        ListNode cur = head;
        while(cur != null){
            ListNode ret = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = ret;
        }
        return newHead;
    }
}
