package DelRepetitionNode;

/**
 *  在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 *  重复的结点不保留，返回链表头指针。 [OJ链接]
 * (https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?
 * tpId=13&&tqId=11209&rp=1&ru=/activity/oj&qru=/ta/
 * coding-interviews/question-ranking)
 */

public class DelNode {
    Node head;
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        Node cur = this.head;
        if(this.head == null){
            this.head = node;
            return;
        }
        while (cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    //打印链表内容
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
    }
    //删除重复的节点
    public Node delNode(){
        Node node = new Node(-1);
        Node cur = this.head;
        Node tmp = node;
        while (cur != null){
            if(cur.getNext() != null && cur.getData() == cur.getNext().getData()){
                while (cur.getNext() != null && cur.getData() == cur.getNext().getData()){
                    cur = cur.getNext();
                }
               cur = cur.getNext();
            }else{
                tmp.setNext(cur);
                tmp = tmp.getNext();
                cur = cur.getNext();
            }
        }
        //尾巴节点也是重复的
        tmp.setNext(null);
        return node.getNext();
    }
}
