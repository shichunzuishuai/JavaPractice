package LinkedList;
public class LinkedList {
    Node head;
    //头插法
    public void addFirst1(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        Node cur = head;
        while (cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    //任意位置插入,下标从0开始
    public void addIndex(int indax,int data){
        Node node = new Node(data);
        Node pre = this.head;
        Node cur = this.head.getNext();
        if(indax < 0 || indax >= size()){
            throw new RuntimeException("index的值不合法");
        }
        if(indax == 0){
            addFirst1(data);
            return;
        }
        if(indax == size() - 1){
            addLast(data);
            return;
        }
        for(int i = 0; i < indax -1; i++){
            cur = cur.getNext();
            pre = pre.getNext();
        }
        node.setNext(cur);
        pre.setNext(node);
    }
    //查找是否包含关键字key在链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while (cur != null){
            if(cur.getData() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    //删除链表中第一次出现的key值
    public void del(int key){
        Node pre = this.head;
        Node cur = this.head.getNext();
        if(this.head.getData() == key){
            head = head.getNext();
            return;
        }
        while (cur != null){
            if(cur.getData() == key){
                pre.setNext(cur.getNext());
                return;
            }
            cur = cur.getNext();
            pre = pre.getNext();
        }
        if(pre == head){
            System.out.println("链表中没有key值");
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node pre = this.head;
        Node cur = this.head.getNext();
        while(cur != null){
            if(cur.getData() == key){
                pre.setNext(cur.getNext());
                cur = cur.getNext();
            }else{
                pre = pre.getNext();
                cur = cur.getNext();
            }
        }
        if(this.head.getData() == key){
            this.head = this.head.getNext();
        }
    }
    //得到链表的长度
    public int size(){
        Node cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    //显示链表中的内容
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
    //清空链表
    public void clear(){
        this.head = null;
    }
}
