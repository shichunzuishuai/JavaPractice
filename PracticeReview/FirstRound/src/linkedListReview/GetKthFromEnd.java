public class GetKthFromEnd {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode s = head;
        ListNode f = head;
        int count = 0;
        while (s != null && f != null){
            if(count < k){
                s = s.next;
                count++;
            }else {
                s = s.next;
                f = f.next;
            }
        }
        return f;
    }
}
