/**
 * 83. 删除排序链表中的重复元素
 * 难度
 * 简单
 * 392
 * 收藏
 * 分享
 * 切换为英文
 * 关注
 * 反馈
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        while (head.next != null &&head.val == head.next.val){
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null ){
            while(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
//        if(cur.next != null && cur.val == cur.next.val){
//            cur.next = null;
//        }
        return head;
    }

    public static void main(String[] args) {

    }
}
