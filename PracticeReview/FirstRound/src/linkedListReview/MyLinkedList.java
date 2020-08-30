/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MyLinkedList {
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    static ListNode head;
    /** Initialize your data structure here. */


    public int getSize() {
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode cur = head;
        if(index < 0 || index >= getSize()){
            return -1;
        }
        while (cur != null && index > 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
//        System.out.println(head);
        ListNode node = new ListNode(val);
        ListNode pre = head;
        ListNode cur = head.next;
      //  System.out.println(pre.val);d
//        System.out.println(cur);

        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == getSize() - 1){
            addAtTail(val);
            return;
        }

        for(int i = 0; i < index - 1; i++){
            cur = cur.next;
            pre = pre.next;

        }
        node.next = cur;
        pre.next = node;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >=0 && index < getSize()){
            if(index == 0){
                head = head.next;
                return;
            }
            if(index == getSize()){
                ListNode pre = head;
                ListNode cur = head.next;
                while (cur != null){
                    cur = cur.next;
                    pre = pre.next;
                }
                pre.next = null;
                return;
            }
            ListNode pre = head;
            ListNode cur = head.next;
            for(int i = 0; i < index - 1; i++){
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = cur.next;
        }
    }

    public void print(){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val+ " ");
            cur = cur.next;
        }
    }
        public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(20);
        myLinkedList.addAtHead(30);
        myLinkedList.addAtHead(40);
        myLinkedList.addAtHead(50);
        myLinkedList.addAtTail(60);
        myLinkedList.addAtTail(70);
      //  myLinkedList.print();
//        myLinkedList.addAtTail(60);
//        myLinkedList.print();
//        System.out.println();
//        int ret = myLinkedList.get(2);
//        System.out.println(ret);
        myLinkedList.addAtIndex(3,10);
            int ret1 = myLinkedList.get(6);
            System.out.println(ret1);
        myLinkedList.deleteAtIndex(3);
            int ret = myLinkedList.get(5);
            System.out.println(ret);
        myLinkedList.print();
        System.out.println();
    }


}

















