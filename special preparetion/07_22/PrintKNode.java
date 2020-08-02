/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */


public class PrintKNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        ListNode forent = head;
        ListNode rear = head;
        while (k > 0 && forent != null) {
            forent = forent.next;
            k--;
        }
        while (forent != null) {
            forent = forent.next;
            rear = rear.next;
        }
        return k > 0 ? null : rear;
    }
}
