/**
 * 输入两个链表，找出它们的第一个公共结点。（
 * 注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * 解题思路：
 * 题目要求是单链表，所以如果有交点，则最后一个链表的节点地址一定是相同的
 * 求第一公共节点，本质是让长的链表先走abs（length1-length2）步，后面大家的步调一致，
 * 往后找第一个地址相同的 节点，就是题目要求的节点 //所以需要各自遍历两次链表
 */
public class FindFirstCommonNode {

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int len1 = GetListLength(pHead1);
        int len2 = GetListLength(pHead2);
        int step = Math.abs(len1 - len2);
         if(len1 > len2){
             while (step > 0){
                 pHead1 = pHead1.next;
                 step--;
             }
         }else {
             while (step > 0){
                 pHead2 = pHead2.next;
                 step--;
             }
         }
         while (pHead1 != null && pHead2 != null){
             if(pHead1 == pHead2){
                 return pHead1;
             }
             pHead1 = pHead1.next;
             pHead2 = pHead2.next;
         }
         return null;
    }

    private int GetListLength(ListNode pHead1) {
        if(pHead1 == null){
            return 0;
        }
        int count = 0;
        while (pHead1 != null){
            pHead1 = pHead1.next;
            count++;
        }
        return count;
    }
}
