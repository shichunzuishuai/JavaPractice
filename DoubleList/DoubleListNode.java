package DoubleList;

import java.util.List;

public class DoubleListNode {
    ListNode head;
    ListNode last;
    //头插法
    public void addFirst(int data){
       ListNode node = new ListNode(data);
       if(this.head == null){
           this.head = node;
           this.last = node;
           return;
       }
       node.setNext(head);
       this.head.setPrev(node);
       this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        } else {
            this.last.setNext(node);
            node.setPrev(this.last);
            last = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()){
            System.out.println("index的值不合法");
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        for(int i = 0; i < index; i++){
            cur = cur.getNext();
        }
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        cur.setPrev(node);
        node.getPrev().setNext(node);
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){

        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;

    }
    //删除第一次出现关键字为key的节点
//    public void remove(int key){
//
//    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

    }
    //得到单链表的长度
    public int size(){
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public void display(){
        ListNode cur = this.head;
        while ( cur != null){
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
    }
    public void clear(){

    }
}
