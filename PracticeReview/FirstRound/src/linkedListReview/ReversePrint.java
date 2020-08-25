public class ReversePrint {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode newHead = null;
        while (head != null){
            ListNode cur = head.next;
            head.next = newHead;
            newHead = head;
            head = cur;
            count++;
        }
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = newHead.val;
            newHead = newHead.next;
        }
        return arr;
    }
}
