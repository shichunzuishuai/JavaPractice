public class DeleteNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                return head;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}
