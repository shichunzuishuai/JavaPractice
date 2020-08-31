/**
 * [编程题]删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null ){
         //   ListNode curNext = cur.next.next;
            if(cur.next != null && cur.val == cur.next.val){while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head.next;
    }
    public ListNode build(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        return l1;
    }

    public static void main(String[] args) {
        DeleteDuplication del = new DeleteDuplication();
        ListNode head = del.build();
        ListNode ret = del.deleteDuplication(head);
        while (ret != null){
            System.out.println(ret.val + " ");
            ret = ret.next;
        }
    }
}
