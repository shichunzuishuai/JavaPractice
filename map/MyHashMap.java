package map;

public class MyHashMap {
    static class Node{
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] array = new Node[101];
    private int size = 0;
    //负载因子: size / array.length();

    public void put(int key,int val){
        int index = func(key);
        Node head = array[index];
        //如果找到了,就直接修改key的val值
        for(Node cur = head; cur != null; cur = cur.next){
            if(cur.key == key){
                cur.val = val;
                return;
            }
        }
        //没有找到,在进行插入
        Node newNode = new Node(key,val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    private int func(int key) {
        return key % array.length;
    }
    public Integer get(int key){
        int index = func(key);
        Node head = array[index];
        for(Node cur = head; cur != null; cur = cur.next){
            if(cur.key == key){
                return cur.val;
            }
        }
        return null;
    }
}
