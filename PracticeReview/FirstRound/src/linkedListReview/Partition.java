/**
 * 链表分割
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
 * 注意：分割以后保持原来的数据顺序不变。
 */

public class Partition {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode partition(ListNode pHead, int x) {
        ListNode min = new ListNode(-1);
        ListNode max = new ListNode(-1);
        ListNode cur = pHead;
        ListNode minCur = min;
        ListNode maxCur = max;
        while (cur != null){
            if(cur.val < x){
                minCur.next = cur;
                minCur = minCur.next;
                cur = cur.next;
            }else{
                maxCur.next = cur;
                maxCur = maxCur.next;
                cur = cur.next;
            }
        }
        minCur.next = max.next;
        return min.next;
    }
}
