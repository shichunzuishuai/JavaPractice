package searcTree;

public class BinarySearchTree {
    static class Node{
        public int key;
        public int val;
        public Node left;
        public Node right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    //查找
    private Node root = null;
    public Node find(int key){
        Node cur = root;
        while (cur != null){
            if(key < cur.key){
                cur = cur.left;
            }else if(key > cur.key){
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }
    //插入
    public Node insert(int key, int val){
        //1.如果是空树,直接让根节点指向新节点那即可
        if(root == null){
            root = new Node(key,val);
            return root;
        }
        //2.先找到key所对应的位置
        Node cur = root;
        Node pre = null;
         while (cur != null){
             if(key < cur.key){
                 pre = cur;
                 cur = cur.left;
             }else if(key > cur.key){
                 pre = cur;
                 cur = cur.right;
             }else {
                 //找到了和key相同值的节点
                 //a)让插入操作直接失败
                 //b)不创建新的节点,直接让当前节点的val等于新的val[此处采用]
                 cur.val = val;
                 return cur;
             }
         }
         //3.循环结束,cur的位置为空,就找到了合适的插入位置
        //此时只需要判断是插入父节点的左子树还是右子树
         Node newNode = new Node(key,val);
         if(newNode.key < pre.key){
             pre.left = newNode;
         }else {
             pre.right = newNode;
         }
         return newNode;
    }
    //先序遍历
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

    //删除元素
    public void remove(int key){
        //先找到要删除的节点位置,同时记录父节点
        Node cur = root;
        Node parent = null;
        while (cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else {
                //找到了要删除的节点
                removeNode(cur,parent);
                return;
            }
        }
        return;
    }

    private void removeNode(Node cur, Node parent) {
        //1.没有左子树的情况
        if(cur.left == null){
            //1.1cur为根节点
            if(cur == root){
                root = cur.right;
            //1.2 cur为父节点的左子树
            }else if(cur == parent.left){
                parent.left = cur.right;
            //1.3 cur为父节点的右子树
            }else if(cur == parent.right){
                parent.right = cur.right;
            }
            //2. 没有右子树的情况
        }else if(cur.right == null){
             //2.1 cur为根节点
            if(cur == root){
                root = cur.left;
            }
            //2.2 cur为父节点的左子树
            else if(cur == parent.left){
                parent.left = cur.left;
            }
            //2.3 cur 为父节点的右子树
            else if(cur == parent.right){
                parent.right = cur.left;
            }
        }else {
            //3. 左右子树都有的情况
            //找一个替罪羊,
            Node scapeGoat = cur.right;
            Node scapeGoatParent = cur;
            while (scapeGoat.left != null){
                scapeGoatParent = scapeGoat;
                scapeGoat = scapeGoatParent.left;
            }
            cur.key = scapeGoat.key;
            cur.val = scapeGoat.val;
            if(scapeGoat == scapeGoatParent.left){
                scapeGoatParent.left = scapeGoat.right;
//            }else {
//                scapeGoatParent.right = scapeGoat.right;
            }
        }
    }
                                                                    

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(9,90);
        b.insert(7,70);
        b.insert(4,40);
        b.insert(8,80);
        b.insert(3,30);
        b.insert(6,60);
        b.remove(9);
        preOrder(b.root);
        System.out.println();
        inOrder(b.root);

    }
}
