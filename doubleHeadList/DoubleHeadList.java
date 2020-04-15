package doubleHeadList;

public class DoubleHeadList {
    //创建头节点
    Node head = new Node(-1);
    Node last = null;
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        Node cur = this.head.getNext();
        //头节点是空的
        if(this.head.getNext() == null) {
            this.head.setNext(node);
            node.setPrev(this.head);
            last = node;
        }else {
            this.head.setNext(node);
            node.setNext(cur);
            node.setPrev(head);
            cur.setPrev(node);
        }
        last = last();
    }
    //定义last
    public Node last(){
        Node cur = this.head.getNext();
        while (cur.getNext() != null){
            cur = cur.getNext();
        }
        return cur;
    }

    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        Node cur = this.head.getNext();
        //头节点你是空的
        if(this.head.getNext() == null) {
            this.head.setNext(node);
            node.setPrev(this.head);
            last = node;
        }else {
            while (cur.getNext() != null){
                cur = cur.getNext();
            }
            cur.setNext(node);
            node.setPrev(cur);
            last = node;
        }
    }
    //任意位置插入,插入下标从0开始
    public void addIndex(int data,int index){
        Node node = new Node(data);
        Node cur = this.head.getNext();
        if(index < 0 || index >= size()){
            throw new RuntimeException("index的位置不合法");
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size() - 1){
            addLast(data);
            return;
        }
        while (index > 0){
            cur = cur.getNext();
            index--;
        }
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        cur.getPrev().setNext(node);
        cur.setPrev(node);
    }
    //查找是否包含关键字key
    public Boolean contains(int key){
        Node cur = this.head.getNext();
        int a = 0;
        while (cur != null){
            if(cur.getData() == key){
                a++;
                break;
            }else {
                cur = cur.getNext();
            }
        }
        if(a == 0){
            return false;
        }else {
            return true;
        }
    }
    //删除第一次出现的key值
    public void remove(int key){
        Node cur = this.head.getNext();
        while (cur != null){
            if(cur.getNext() != null && cur.getData() == key){
                cur.getNext().setPrev(cur.getPrev());
                cur.getPrev().setNext(cur.getNext());
                break;
            } if(cur.getNext() == null){
                last.getPrev().setNext(null);
                break;
            }
            else{
                cur = cur.getNext();
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node cur = this.head.getNext();
        while (cur != null) {
            if (cur.getNext() != null && cur.getData() == key) {
                cur.getNext().setPrev(cur.getPrev());
                cur.getPrev().setNext(cur.getNext());
            }
            if (cur.getNext() == null) {
                last.getPrev().setNext(null);
                break;
            } else {
                cur = cur.getNext();
            }
        }
    }
    //清除链表
    public void clean(){
        this.head = null;
        this.last = null;
    }

    //得到链表的长度
    public int size(){
        Node cur = this.head.getNext();
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    //显示链表中的内容
    public void display(){
        if(this.head == null && this.last == null){
            System.out.println("链表为空");
            return;
        }
        Node cur = this.head.getNext();
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }
}
