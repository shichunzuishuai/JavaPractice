public class MergeTwoListNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //带头节点的合并
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newNode = new ListNode(-1);
        ListNode cur = newNode;
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        while (list1 !=null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else if(list1.val >= list2.val){
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 == null){
            cur.next = list2;
        }else if(list2 == null){
            cur.next = list1;
        }
        return newNode.next;
    }
    //不带头节点的合并
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode new_head = null;
        ListNode new_tail = null;
        while (list1 != null && list2 != null){
            ListNode p = list1.val < list2.val ? list1 : list2;
            if(p == list1){
                list1 = list1.next;
            }else {
                list2 = list2.next;
            }
            if(new_head == null){
                new_head = p;
                new_tail = p;
            }else {
                new_tail.next = p;
                new_tail = p;
            }
        }
        if(list1 == null){
            new_tail.next = list2;
        }else if(list2 == null){
            new_tail.next = list1;
        }
        return new_head;
    }
    //3.使用递归的方法
    public ListNode Merge3(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode new_head = null;
        if(list1.val < list2.val){
            new_head = list1;
            list1 = list1.next;
        }else {
            new_head = list2;
            list2 = list2.next;
        }
       new_head.next = Merge3(list1,list2);
        return new_head;
    }
}
