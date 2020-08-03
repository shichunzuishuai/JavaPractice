
public class ReserveNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //方法一:定义三个下标,Mid下标进行翻转
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode mid = left.next;
        ListNode right = mid.next;
        while (right != null){
            mid.next = left;
            left = mid;
            mid = right;
            right = right.next;
        }
        mid.next = left;
        head.next = null;
        head = mid;
        return head;
    }
    //定义一个新的链表节点,然后把旧链表的头节点取下来头查到新的头节点
    public ListNode ReverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode new_head = null;
        while (head != null){
            ListNode node = head;
            head = head.next;
            node.next = new_head;
            new_head = node;
        }
        return new_head;
    }
}
